package com.cd.tictactoe.strategy.winningStrategy;

import com.cd.tictactoe.models.Board;
import com.cd.tictactoe.models.Cell;
import com.cd.tictactoe.models.Player;

public interface GameWinningStrategy {

    boolean checkIfWon(Board board, Player player, Cell cell);
}
