import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.HttpServer;
package com.example
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Starting Simple HTTP Server...");

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", exchange -> {
            String response = "Hello from Java App Running in Docker!";
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });

        server.setExecutor(null);
        server.start();

        System.out.println("Server running on http://localhost:8080/");
    }
}
