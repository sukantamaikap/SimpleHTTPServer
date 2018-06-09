package com.vm.round1;

import com.vm.round1.server.Server;

import java.io.IOException;

public class SimpleHTTPSerrver {

    public static void main(final String[] args) throws IOException {
        final Server server = new Server(8989);
        while (Boolean.TRUE) {
            server.openServerSocket();
            server.showClientRequest();
            server.respondAndShowTime();
        }

    }
}
