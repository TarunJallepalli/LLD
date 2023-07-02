package com.tarunj.tictactoe.Models;

import java.util.Scanner;

public class Player {

    char ch;
    int id;
    String name;
    PlayerType playerType;
    Scanner sc;

    public Player(char ch, int id, String name, PlayerType playerType) {
        
        this.ch = ch;
        this.id = id;
        this.name = name;
        this.playerType = playerType;
        sc = new Scanner(System.in);
    }

    public char getCh() {
        return ch;
    }

    public void setCh(char ch) {
        this.ch = ch;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerType getType() {
        return playerType;
    }

    public void setType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Move makeMove(Board board) {

        int row = -1, col = -1;

        System.out.println("This is " + name + "'s turn to move.");

        System.out.println("Enter the row you want to move :");
        row = sc.nextInt();
        
        System.out.println("Enter the col you want to move :");
        col = sc.nextInt();

        return new Move(new Cell(row, col), this);
    }

}
