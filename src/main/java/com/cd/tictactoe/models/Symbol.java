package com.cd.tictactoe.models;

public class Symbol {
    private char character;
    public Symbol(char val){
        character = val;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }
}
