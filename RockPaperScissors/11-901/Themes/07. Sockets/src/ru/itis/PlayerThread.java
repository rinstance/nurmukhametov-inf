package ru.itis;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PlayerThread extends Thread {
    private static List<PrintWriter> printWriters = new ArrayList<>();
    protected Socket client;
    private int playerNumber;
    private final String CHOOSE = "CHOOSE";
    private final String PLAYER = "Player";
    private final String RESULT = "RESULT";
    private final String RESTART = "RESTART";
    private static HashMap<Integer, String> map = new HashMap<>();
    private BufferedReader fromClient;
    private PrintWriter toClient;

    public PlayerThread(Socket clientSocket, int playerNumber) {
        this.client = clientSocket;
        this.playerNumber = playerNumber;
        try {
            fromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
            toClient = new PrintWriter(client.getOutputStream(), true);
            printWriters.add(toClient);
        } catch (Exception e) {e.printStackTrace();}
    }

    // читаем сообщения от клиента
    public void run() {
        try {

            // send player title
            toClient.println(PLAYER + ": " + playerNumber);

            String messageFromClient = fromClient.readLine();
            while (messageFromClient != null) {
                // from client
                System.out.println("Message from client: player " + playerNumber + " " + messageFromClient);
                // send choice
                toClient.println(CHOOSE + " " + playerNumber + " " + messageFromClient);

                if (messageFromClient.split(" ")[0].equals(CHOOSE)) {
                    addToMap(messageFromClient.split(" "));
                }

                if (messageFromClient.equals(RESTART))
                    restart();

                messageFromClient = fromClient.readLine();
            }
        } catch (Exception e) { e.printStackTrace(); }
    }

    private void restart() {
        map.clear();
        printWriters.get(0).println(RESTART);
        printWriters.get(1).println(RESTART);
    }

    private void addToMap(String[] strings) {
        map.put(playerNumber, strings[1]);
        if (map.size() == 2)
            showResult();
    }

    private void showResult() {
        String first = RESULT + " 1 " + map.get(1);
        String second = RESULT + " 2 " + map.get(2);
        for (PrintWriter printWriter : printWriters) {
            printWriter.println(first);
            printWriter.println(second);
        }
    }
}
