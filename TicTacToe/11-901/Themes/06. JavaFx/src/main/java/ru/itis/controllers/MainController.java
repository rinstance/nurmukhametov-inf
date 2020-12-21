package ru.itis.controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import ru.itis.game.Game;
import ru.itis.sockets.ReceiveMessageTask;
import ru.itis.sockets.SocketClient;
import ru.itis.utils.ChoiceEnum;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 26.11.2020
 * 06. JavaFx
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class MainController implements Initializable {
    @FXML
    private AnchorPane pane;
    @FXML
    private Button rockButton;
    @FXML
    private Button paperButton;
    @FXML
    private Button scissorsButton;
    @FXML
    public Label player;
    @FXML
    public Label player1Choose;
    @FXML
    public Label player2Choose;
    @FXML
    public Button againButton;

    private SocketClient client;

    public EventHandler<KeyEvent> keyEventEventHandler = event -> {
    };

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        client = new SocketClient("localhost", 7777);
        // запускаем слушателя сообщений
        ReceiveMessageTask receiveMessageTask = new ReceiveMessageTask(client.getFromServer(), this);
        ExecutorService service = Executors.newFixedThreadPool(1);
        service.execute(receiveMessageTask);


        rockButton.setOnAction(event -> {
            choose(ChoiceEnum.ROCK);
        });
        paperButton.setOnAction(event -> {
            choose(ChoiceEnum.PAPER);
        });
        scissorsButton.setOnAction(event -> {
            choose(ChoiceEnum.SCISSORS);
        });
        againButton.setOnAction(event -> {
            if (Game.isEnd) {
                client.sendRestart();
            }
        });
    }

    private void choose(ChoiceEnum choice) {
        if (!Game.isChoose) {
            client.sendMessage(choice);
            Game.isChoose = true;
        }
    }
}
