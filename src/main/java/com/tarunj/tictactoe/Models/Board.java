package com.tarunj.tictactoe.Models;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private int size;
    private List<List<Cell>> board;

    public Board(int boardDimension) {

        size = boardDimension;
        board = new ArrayList<>();

        for(int i = 0; i < boardDimension; i++) {
            
            board.add(new ArrayList<Cell>());
            
            for(int j = 0; j < boardDimension; j++)
                board.get(i).add(new Cell(i, j));    
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    public void printBoard() {

        for(List<Cell> row : board) {

            for(Cell cell : row) {

                if(cell.getCellState().equals(CellState.EMPTY))
                    System.out.print("| _ | ");
                
                else System.out.print("| " + cell.getPlayer().getCh() + " | ");
            }

            System.out.println('\n');
        }
    }

}
