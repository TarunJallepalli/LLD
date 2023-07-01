package com.tarunj.tictactoe.Models;

public class Player {

    char ch;
    int id;
    String name;
    PlayerType playerType;

    public Player(char ch, int id, String name, PlayerType playerType) {
        
        this.ch = ch;
        this.id = id;
        this.name = name;
        this.playerType = playerType;
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

}
