package com.tarunj.tictactoe.Models;

public class Bot extends Player{
    
    BotDifficultyLevel difficultyLevel;

    public BotDifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(BotDifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }
}
