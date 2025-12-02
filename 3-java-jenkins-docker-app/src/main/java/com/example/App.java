package com.example;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Starting Simple HTTP Server...");

        HttpServer server = HttpServer.create(new InetSocketAddress(80), 0);

        server.createContext("/", exchange -> {
            String response = "Hello from Java App Running inside Docker on Mac!";
            exchange.sendResponseHeaders(200, response.length());
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        });

        server.setExecutor(null);
        server.start();

        System.out.println("Server is running at http://localhost:80/");
    }
}
