package ru.itis;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/**
 * 30.11.2020
 * 07. Sockets
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class EchoServerSocket {
    private static int playerCount = 0;
    private static HashMap<Integer, String> map = new HashMap<>();

    public void start(int port) {
        ServerSocket server;

        try {
            server = new ServerSocket(port);
            // уводит приложение в ожидание, пока не подключится клиент
            // как только клиент подключился, поток продолжает выполнение и помещает
            // "клиента" в client
            while (playerCount < 2) {
                Socket client = server.accept();
                playerCount += 1;
                new PlayerThread(client, playerCount).start();
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
