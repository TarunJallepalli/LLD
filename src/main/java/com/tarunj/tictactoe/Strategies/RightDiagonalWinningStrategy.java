package com.tarunj.tictactoe.Strategies;

import java.util.HashMap;
import java.util.Map;

import com.tarunj.tictactoe.Models.Board;
import com.tarunj.tictactoe.Models.Move;

public class RightDiagonalWinningStrategy implements WinningStrategy{
    
    private final Map<Character, Integer> rightDiagMap = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        char playerChar = move.getPlayer().getCh();

        if(row + col != board.getSize()) return false;

        if(!rightDiagMap.containsKey(playerChar)) rightDiagMap.put(playerChar, 0);
            rightDiagMap.put(playerChar, rightDiagMap.get(playerChar) + 1);

        return (rightDiagMap.get(playerChar).equals(board.getSize()));
    }
}