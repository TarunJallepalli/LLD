package com.tarunj.tictactoe.Strategies;

import java.util.HashMap;
import java.util.Map;

import com.tarunj.tictactoe.Models.Board;
import com.tarunj.tictactoe.Models.Move;

public class LeftDiagonalWinningStrategy implements WinningStrategy{

    private final Map<Character, Integer> leftDiagMap = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        char playerChar = move.getPlayer().getCh();

        if(row != col) return false;

        if(!leftDiagMap.containsKey(playerChar)) leftDiagMap.put(playerChar, 0);
            leftDiagMap.put(playerChar, leftDiagMap.get(playerChar) + 1);

        return (leftDiagMap.get(playerChar).equals(board.getSize()));
    }
}
