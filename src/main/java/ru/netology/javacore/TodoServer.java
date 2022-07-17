package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {
    private final int port;
    private final Todos todos;

    public TodoServer (int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start () throws IOException {
        System.out.println("Starting server at " + port + "...");
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        try (ServerSocket serverSocket = new ServerSocket(port)) { // стартуем сервер один(!) раз
            while (true) { // в цикле(!) принимаем подключения
                try (
                        Socket socket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
                ) {
                    // обработка одного подключения
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    String request = in.readLine();
                    Todos todo = gson.fromJson(request, Todos.class);
                    switch (todo.getType()) {
                        case "ADD":
                            todos.addTask(todo.getTask());
                            break;
                        case "REMOVE":
                            todos.removeTask(todo.getTask());
                            break;
                        default:
                            System.out.println("Wrong operation");
                            break;
                    }
                    out.println(todos.getAllTasks());
                }
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }
}
