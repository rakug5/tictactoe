package com.cd.tictactoe.controllers;

import com.cd.tictactoe.exception.EmptyMovesUndoOperationException;
import com.cd.tictactoe.exception.MultipleBotException;
import com.cd.tictactoe.models.Game;
import com.cd.tictactoe.models.GameStatus;
import com.cd.tictactoe.models.Player;
import com.cd.tictactoe.strategy.winningStrategy.GameWinningStrategy;

import java.util.List;

public class GameController {
    public Game createGame(int dimension, List<Player> players, List<GameWinningStrategy> strategies) {
        Game game;
        try {
            game = Game.create().addPlayers(players)
                    .setDimension(dimension)
                    .addWinningStrategies(strategies).build();

        } catch (MultipleBotException e) {
            throw new RuntimeException(e);
        }
        return game;
    }

    public void makeMove(Game game) {
        game.makeMove();
    }

    public void undo(Game game) throws EmptyMovesUndoOperationException {
        game.undo();
    }

    public Player getWinner(Game game){
        return game.getWinner();
    }
    public GameStatus gameStatus(Game game){
        return game.getGameStatus();
    }
    public void display(Game game){
        game.getBoard().printBoard();
    }

}
