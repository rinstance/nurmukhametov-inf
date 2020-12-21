package ru.itis.sockets;

import ru.itis.utils.ChoiceEnum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {
    private final String CHOOSE = "CHOOSE";
    private final String RESTART = "RESTART";
    private Socket client;

    private PrintWriter toServer; // на EchoServerSocket fromClient
    private BufferedReader fromServer; // на EchoServerSocket toClient

    public SocketClient(String host, int port) {
        try {
            client = new Socket(host, port);
            toServer = new PrintWriter(client.getOutputStream(), true);
            fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public void sendMessage(ChoiceEnum choose) {
        toServer.println(CHOOSE + " " + choose.name());
    }

    public void sendRestart() {
        toServer.println(RESTART);
    }

    public BufferedReader getFromServer() {
        return fromServer;
    }
}
