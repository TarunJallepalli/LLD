package com.tarunj.tictactoe.Models;

public class Bot extends Player{
    
    BotDifficultyLevel botDifficultyLevel;

    public Bot(char ch, int id, String name, PlayerType playerType, BotDifficultyLevel botDifficultyLevel) {

        super(ch, id, name, PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
    }

    public BotDifficultyLevel getbotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }
}
