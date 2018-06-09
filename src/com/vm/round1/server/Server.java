package com.vm.round1.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

public class Server {
    private int port = 80;

    ServerSocket serverSocket = null;
    private Socket socket;
    private InputStream inputStream = null;
    private BufferedReader bufferedReader = null;

    public Server() throws IOException {
        this.openServerSocket();
    }

    public Server(final int port) throws IOException {
        this.port = port;
        System.out.println("Opening server socket !!!!");
        this.serverSocket = new ServerSocket(this.port);
    }

    public void openServerSocket() throws IOException {
        System.out.println("Waiting for request on socket !!!!");
        this.socket = serverSocket.accept();
        System.out.println("Request received !!!");
    }

    public void showClientRequest() throws IOException {
//        try {
            this.inputStream = this.socket.getInputStream();
            this.bufferedReader = new BufferedReader(new InputStreamReader(this.inputStream));
            System.out.println("Printing client request !!!");
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                System.out.println(str);
                if (str.isEmpty()) {
                    break;
                }
            }

            System.out.println("Client request end !!!");
//        } finally {
//            bufferedReader.close();
//            inputStream.close();
//        }
    }

    /**
     * Shows the timer as response !!!
     * @throws IOException
     */
    public void respondAndShowTime() throws IOException {
        if (this.socket != null) {
            try {
                System.out.println("Responding with 200 OK and DATE !!");
                Date today = new Date();
                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today + "\r\n\r\n";
                this.socket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
            } finally {
                this.socket.close();
                this.serverSocket.close();
            }
        } else {
            System.out.println("Socket is not instantiated !!!");
        }
    }
}
