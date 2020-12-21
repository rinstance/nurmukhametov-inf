package ru.itis.game;

import ru.itis.utils.ChoiceEnum;

public class Game {
    public static boolean isChoose = false;
    public static String player = "";
    public static int playerNumber = 0;
    public static boolean isEnd = false;
    private static String FIRST = "1";
    private static String SECOND = "2";

    public static String getWonPlayerNumber(ChoiceEnum player1Choice, ChoiceEnum player2Choice) {
        if (player1Choice == ChoiceEnum.PAPER) {
            if (player2Choice == ChoiceEnum.ROCK) return FIRST;
            if (player2Choice == ChoiceEnum.SCISSORS) return SECOND;
        } else if (player1Choice == ChoiceEnum.ROCK) {
            if (player2Choice == ChoiceEnum.SCISSORS) return FIRST;
            if (player2Choice == ChoiceEnum.PAPER) return SECOND;
        } else if (player1Choice == ChoiceEnum.SCISSORS) {
            if (player2Choice == ChoiceEnum.PAPER) return FIRST;
            if (player2Choice == ChoiceEnum.ROCK) return SECOND;
        }
        return null;
    }

    public static boolean isSimilar(ChoiceEnum player1Choice, ChoiceEnum player2Choice) {
        return player1Choice == player2Choice;
    }
}
