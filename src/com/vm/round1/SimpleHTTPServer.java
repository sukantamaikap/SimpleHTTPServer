package com.vm.round1;

import com.vm.round1.server.TimeTeller;

import java.io.IOException;

public class SimpleHTTPServer {

    public static void main(final String[] args) throws IOException, InterruptedException {
        System.out.println("Sarting server !!!");
        final TimeTeller timeTeller = new TimeTeller(8989);
        System.out.println("Server stopped !!!");
    }
}
