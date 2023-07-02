package com.tarunj.tictactoe.Strategies;

import java.util.List;

import com.tarunj.tictactoe.Models.Board;
import com.tarunj.tictactoe.Models.Cell;
import com.tarunj.tictactoe.Models.CellState;
import com.tarunj.tictactoe.Models.Move;

public class EasyBotPlayingStrategy implements BotPlayingStrategy{

    public Move makeMove(Board board) {
        
        for(List<Cell> row : board.getBoard()) {
            
            for(Cell cell : row) {
            
                if(cell.getCellState().equals(CellState.EMPTY))
                    return new Move(cell, null);
            }
        }

        return null;
    }
}
