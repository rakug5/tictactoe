package com.cd.tictactoe;

import com.cd.tictactoe.controllers.GameController;
import com.cd.tictactoe.models.*;
import com.cd.tictactoe.strategy.playingstrategy.BotPlayingStrategy;
import com.cd.tictactoe.strategy.playingstrategy.RandomBotPlayingStrategy;
import com.cd.tictactoe.strategy.winningStrategy.GameWinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class GameSimulator {
    public static void main(String[] args) {
        int dimension = 3;
        Player p1 = new HumanPlayer();
        p1.setName("Ravi");
        p1.setType(PlayerType.HUMAN);
        p1.setSymbol(new Symbol('X'));

        BotPlayingStrategy strategy = new RandomBotPlayingStrategy();
        Player p2 = new BotPlayer(strategy, BotDifficultyLevel.MEDIUM);
        p2.setSymbol(new Symbol('O'));
        p2.setType(PlayerType.BOT);
        p2.setName("bot");
        List<Player> players = new ArrayList<>();
        players.add(p1);
        players.add(p2);
        GameController gameController = new GameController();
        List<GameWinningStrategy> strategies = new ArrayList<>();
        Game game = gameController.createGame(dimension,
                players, strategies);
        while (game.getGameStatus().equals(GameStatus.IN_PROGRESS)) {
            gameController.display(game);
            gameController.makeMove(game);
        }
        if(gameController.gameStatus(game).equals(GameStatus.COMPLETED)){
            System.out.println("Winner is ->");
        }

    }

}
