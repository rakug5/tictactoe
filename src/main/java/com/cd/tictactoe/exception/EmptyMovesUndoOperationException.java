package com.cd.tictactoe.exception;

public class EmptyMovesUndoOperationException extends Exception
{
    public EmptyMovesUndoOperationException(){
        super("No Moves Happened");
    }

}
