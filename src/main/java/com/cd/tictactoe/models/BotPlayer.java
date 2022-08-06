package com.cd.tictactoe.models;

import com.cd.tictactoe.strategy.playingstrategy.BotPlayingStrategy;

public class BotPlayer extends Player {
    private BotPlayingStrategy botPlayingStrategy;
    private BotDifficultyLevel level;

    public BotPlayer(BotPlayingStrategy botPlayingStrategy, BotDifficultyLevel level) {
        super(PlayerType.BOT);
        this.botPlayingStrategy = botPlayingStrategy;
        this.level = level;
    }

    @Override
    public Move makeMove(Board board) {
        return botPlayingStrategy.makeBotMove(board, this);
    }
}
