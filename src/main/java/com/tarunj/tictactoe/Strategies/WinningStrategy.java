package com.tarunj.tictactoe.Strategies;

import com.tarunj.tictactoe.Models.Board;
import com.tarunj.tictactoe.Models.Move;

public interface WinningStrategy {
    
    public boolean checkWinner(Board board, Move move);

    public void handleMoveUndo(Board board, Move lastMove);
}
