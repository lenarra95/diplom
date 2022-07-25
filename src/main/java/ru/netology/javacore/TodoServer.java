package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class TodoServer {
    private final int port;
    private final Todos todos;

    public TodoServer (int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start () throws IOException {
        Operations operations = new Operations();
        System.out.println("Starting server at " + port + "...");
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        List<String> tasks;
        try (ServerSocket serverSocket = new ServerSocket(port)) { // стартуем сервер один(!) раз
            while (true) { // в цикле(!) принимаем подключения
                try (
                        Socket socket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
                ) {
                    // обработка одного подключения
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    String request = in.readLine();
                    InputFormat json = gson.fromJson(request, InputFormat.class);
                    switch (json.getType()) {
                        case "ADD":
                            tasks = operations.addTask(todos.getTasks(), json.getTask());
                            todos.setTasks(tasks);
                            break;
                        case "REMOVE":
                            tasks = operations.removeTask(todos.getTasks(), json.getTask());
                            todos.setTasks(tasks);
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
