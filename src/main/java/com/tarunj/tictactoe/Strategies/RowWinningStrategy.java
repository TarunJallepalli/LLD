package com.tarunj.tictactoe.Strategies;

import java.util.HashMap;
import java.util.Map;

import com.tarunj.tictactoe.Models.Board;
import com.tarunj.tictactoe.Models.Move;

public class RowWinningStrategy implements WinningStrategy{

    private final Map<Integer, HashMap<Character, Integer>> rowCount = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {

        int row = move.getCell().getRow();
        char playerChar = move.getPlayer().getCh();

        if(!rowCount.containsKey(row)) rowCount.put(row, new HashMap<Character, Integer>());
        HashMap<Character, Integer> rowMap = rowCount.get(row); 

        if(!rowMap.containsKey(playerChar)) rowMap.put(playerChar, 0);
        rowMap.put(playerChar, rowMap.get(playerChar) + 1);

        return (rowMap.get(playerChar).equals(board.getSize()));
    }
}
