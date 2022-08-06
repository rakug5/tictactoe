package com.cd.tictactoe.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int dimension;
    private List<List<Cell>> board;

    public int getDimension() {
        return dimension;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    public Board(int dimension) {
        this.dimension = dimension;
        this.board = new ArrayList<>();
        for (int i = 0; i < dimension; i++) {
            board.add(new ArrayList<>(this.dimension));
        }
    }

    public Cell getCell(int row, int col){
        return board.get(row).get(col);
    }

    public void printBoard(){
        for(List<Cell> row : this.getBoard()){
            for(Cell cell : row) {
                System.out.println(cell.getSymbol()+ " ");
            }
            System.out.println("\n");
        }
    }

}
