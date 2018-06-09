package com.vm.round1.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeTeller {
    private int port = 80;

    ServerSocket serverSocket = null;
    private Socket clientSocket = null;
    private InputStream inputStream = null;
    private BufferedReader bufferedReader = null;

    public TimeTeller() throws IOException, InterruptedException {
        System.out.println("Opening server clientSocket !!!!");
        this.serverSocket = new ServerSocket(this.port);
        this.openServerSocket();
    }

    public TimeTeller(final int port) throws IOException, InterruptedException {
        this.port = port;
        System.out.println("Opening server clientSocket !!!!");
        this.serverSocket = new ServerSocket(this.port);
        this.openServerSocket();
    }

    public void openServerSocket() throws IOException, InterruptedException {
        System.out.println("Waiting for request on clientSocket !!!!");
        this.clientSocket = serverSocket.accept();
        System.out.println("Request received from client : " + this.clientSocket.getInetAddress().getCanonicalHostName());
        this.showClientRequest();
        this.respondAndShowTime();
    }

    public synchronized void showClientRequest() throws IOException {

        this.inputStream = this.clientSocket.getInputStream();
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
    }

    /**
     * Shows the timer as response !!!
     * @throws IOException
     */
    public synchronized void respondAndShowTime() throws IOException, InterruptedException {
        System.out.println("Responding with 200 OK and DATE !!");
        String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + new Timer().getCurrentDateAndTime() + "\r\n\r\n";
        this.clientSocket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
        this.clientSocket.getOutputStream().flush();
        System.out.println("Response sent to client !!!!");
    }
}
