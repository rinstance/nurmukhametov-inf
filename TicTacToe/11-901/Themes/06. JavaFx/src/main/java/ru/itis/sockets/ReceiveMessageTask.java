package ru.itis.sockets;

import javafx.application.Platform;
import javafx.concurrent.Task;
import ru.itis.game.Game;
import ru.itis.controllers.MainController;
import ru.itis.utils.ChoiceEnum;

import java.io.BufferedReader;
import java.io.IOException;

// слушатель сообщений от сервера
public class ReceiveMessageTask extends Task<Void> {
    private final String PLAYER = "Player";
    private final String RESULT = "RESULT";
    private final String RESTART = "RESTART";
    private final String AGAIN_BUTTON = ". Again? Click anyone";
    private ChoiceEnum player1Choice, player2Choice;

    // читаем сообщения с сервера
    private BufferedReader fromServer; // на EchoServerSocket toClient

    private MainController controller;

    public ReceiveMessageTask(BufferedReader fromServer, MainController controller) {
        this.fromServer = fromServer;
        this.controller = controller;
    }

    @Override
    protected Void call() throws Exception {
        while (true) {
            try {
                String messageFromServer = fromServer.readLine();
                System.out.println(messageFromServer);
                if (messageFromServer != null) {
                    if (messageFromServer.split(":")[0].equals(PLAYER)) {
                        Game.player = messageFromServer;
                        Game.playerNumber = Integer.parseInt(messageFromServer.split(" ")[1]);
                        Platform.runLater(() -> controller.player.setText(Game.player));
                    } else if (messageFromServer.split(" ")[0].equals(RESULT)) {
                        setResults(messageFromServer.split(" "));
                    } else if (messageFromServer.equals(RESTART)) {
                        restart();
                    }
                }
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    private void restart() {
        Game.isChoose = false;
        Game.isEnd = false;
        Platform.runLater(() -> controller.player1Choose.setText("Waiting for both players"));
        Platform.runLater(() -> controller.player2Choose.setText("Waiting for both players"));
        Platform.runLater(() -> controller.againButton.setText("Waiting for both players"));
    }

    private void setResults(String[] strings) {
        if (strings[1].equals("1")) {
            player1Choice = ChoiceEnum.valueOf(strings[2]);
            Platform.runLater(() -> controller.player1Choose.setText("Player 1: " + player1Choice));
        }
        else if (strings[1].equals("2")) {
            player2Choice = ChoiceEnum.valueOf(strings[2]);
            Platform.runLater(() -> controller.player2Choose.setText("Player 2: " + player2Choice));
        }
        setResultButton(player1Choice, player2Choice);
        Game.isEnd = true;
    }

    private void setResultButton(ChoiceEnum player1Choice, ChoiceEnum player2Choice) {
        if (Game.isSimilar(player1Choice, player2Choice))
            Platform.runLater(() -> controller.againButton.setText("Draw" + AGAIN_BUTTON));
        else {
            String wonPlayerNumber = Game.getWonPlayerNumber(player1Choice, player2Choice);
            if (wonPlayerNumber != null)
                Platform.runLater(() -> controller.againButton.setText("Player " + wonPlayerNumber + AGAIN_BUTTON));
        }
    }
}
