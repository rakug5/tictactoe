package com.cd.tictactoe.models;

import com.cd.tictactoe.exception.EmptyMovesUndoOperationException;
import com.cd.tictactoe.exception.MultipleBotException;
import com.cd.tictactoe.strategy.winningStrategy.GameWinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private int moveCount;
    private GameStatus gameStatus;
    private List<GameWinningStrategy> gameWinningStrategies;
    private Player winner;
    private int filledCells;


    public void makeMove() {
        this.moveCount += 1;
        this.moveCount %= this.players.size();
        Move move = this.players.get(this.moveCount).makeMove(this.board);
        this.moves.add(move);
        filledCells += 1;
        for (GameWinningStrategy strategy : gameWinningStrategies) {
            strategy.checkIfWon(board, this.players.get(moveCount), move.getCell());
            this.gameStatus = GameStatus.COMPLETED;
            winner = this.players.get(moveCount);
            break;
        }
        if (this.board.getDimension() * this.board.getDimension() == filledCells) {
            this.gameStatus = GameStatus.DRAW;
            return;
        }

    }

    public boolean undo() throws EmptyMovesUndoOperationException {
        if (this.moves.size() == 0) {
            throw new EmptyMovesUndoOperationException();
        }
        int currentIndex = this.moves.size();
        this.moves.remove(currentIndex - 1);
        moveCount -= 1;
        moveCount = (moveCount + this.players.size()) % this.players.size();
        return true;
    }

    public Board getBoard() {
        return board;
    }


    public List<Player> getPlayers() {
        return players;
    }


    public int getMoveCount() {
        return moveCount;
    }


    public GameStatus getGameStatus() {
        return gameStatus;
    }


    private Game() {

    }

    public static Builder create() {
        return new Builder();
    }

    public Player getWinner() {
        return winner;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public List<GameWinningStrategy> getGameWinningStrategies() {
        return gameWinningStrategies;
    }

    public static class Builder {
        private List<Player> players;
        private List<GameWinningStrategy> gameWinningStrategies;
        private int dimension;

        Builder() {
            this.players = new ArrayList<>();
            this.gameWinningStrategies = new ArrayList<>();
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder addPlayer(Player player) {
            players.add(player);
            return this;
        }

        public Builder addPlayers(List<Player> players) {
            this.players.addAll(players);
            return this;
        }

        public Builder addWinningStrategy(GameWinningStrategy gameWinningStrategy) {
            gameWinningStrategies.add(gameWinningStrategy);
            return this;
        }

        public Builder addWinningStrategies(List<GameWinningStrategy> gameWinningStrategies) {
            this.gameWinningStrategies.addAll(gameWinningStrategies);
            return this;
        }

        public Game build() throws MultipleBotException {
            if (!isOneBotMax()) {
                throw new MultipleBotException();
            }
            /***
             * Other Validations required for number of players, minimum dimension can go here.
             */
            Game game = new Game();
            game.moves = new ArrayList<>();
            game.gameStatus = GameStatus.IN_PROGRESS;
            game.gameWinningStrategies = this.gameWinningStrategies;
            game.players = this.players;
            game.board = (new Board(dimension));
            return game;
        }


        private boolean isOneBotMax() {
            int count = 0;
            for (Player player : players) {
                if (player.getType() == PlayerType.BOT
                ) {
                    count++;
                }
            }
            return count <= 1;
        }
    }
}
