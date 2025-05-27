package com.mokitooo.server;

import com.mokitooo.service.BookService;
import lombok.Cleanup;
import org.springframework.beans.factory.annotation.Value;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final int port;
    private final String host;
    private final BookService bookService;
    private volatile boolean running;

    public Server(
            @Value("${server.library.port:8080}") int port,
            @Value("${server.library.host:127.0.0.1}") String host,
            BookService bookService
    ) {
        this.port = port;
        this.host = host;
        this.bookService = bookService;
    }

    public void startAsync() {
        new Thread(() -> {
            running = true;
            while (running) {
                @Cleanup ServerSocket serverSocket = new ServerSocket(port, 50, InetAddress.getByName(host));
                Socket socket = serverSocket.accept();
            }
        }).start();
    }

    public void stop() {
        running = false;
    }

    private class ClientHandler {
        
    }
}
