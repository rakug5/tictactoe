package com.cd.tictactoe.strategy.playingstrategy;

import com.cd.tictactoe.models.Board;
import com.cd.tictactoe.models.Move;
import com.cd.tictactoe.models.Player;

public interface BotPlayingStrategy {
    Move makeBotMove(Board board, Player player);
}
