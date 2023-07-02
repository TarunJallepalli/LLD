package com.tarunj.tictactoe.Strategies;

import java.util.HashMap;
import java.util.Map;

import com.tarunj.tictactoe.Models.Board;
import com.tarunj.tictactoe.Models.Move;

public class ColumnWinningStrategy implements WinningStrategy{

    private final Map<Integer, HashMap<Character, Integer>> colCount = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {

        int col = move.getCell().getCol();
        char playerChar = move.getPlayer().getCh();

        if(!colCount.containsKey(col)) colCount.put(col, new HashMap<Character, Integer>());
        HashMap<Character, Integer> colMap = colCount.get(col); 

        if(!colMap.containsKey(playerChar)) colMap.put(playerChar, 0);
        colMap.put(playerChar, colMap.get(playerChar) + 1);

        return (colMap.get(playerChar).equals(board.getSize()));
    }
}
