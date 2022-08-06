package com.cd.tictactoe.strategy.playingstrategy;

import com.cd.tictactoe.models.Board;
import com.cd.tictactoe.models.Cell;
import com.cd.tictactoe.models.Move;
import com.cd.tictactoe.models.Player;

import java.util.List;

public class RandomBotPlayingStrategy implements BotPlayingStrategy {
    @Override
    public Move makeBotMove(Board board, Player player) {
        for (List<Cell> row : board.getBoard()) {
            for (Cell cell : row) {
                if (cell.isEmpty()) {
                    cell.setSymbol(player.getSymbol());
                    Move move = new Move();
                    move.setCell(cell);
                    move.setPlayer(player);
                    return move;
                }
            }
        }
        return null;
    }
}
