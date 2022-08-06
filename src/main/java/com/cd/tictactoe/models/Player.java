package com.cd.tictactoe.models;

public abstract class Player {
    private String name;
    private Symbol symbol;
    private PlayerType type;

    Player(PlayerType playerType) {
        this.type = playerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getType() {
        return type;
    }

    public void setType(PlayerType type) {
        this.type = type;
    }

    public abstract Move makeMove(Board board);
}
