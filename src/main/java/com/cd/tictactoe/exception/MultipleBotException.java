package com.cd.tictactoe.exception;

public class MultipleBotException extends Exception {
    public MultipleBotException() {
        super("A game cant have more than one Bot");
    }

}
