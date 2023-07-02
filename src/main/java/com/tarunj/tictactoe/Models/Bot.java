package com.tarunj.tictactoe.Models;

import com.tarunj.tictactoe.Strategies.BotPlayingFactory;
import com.tarunj.tictactoe.Strategies.BotPlayingStrategy;

public class Bot extends Player{
    
    BotDifficultyLevel botDifficultyLevel;
    BotPlayingStrategy botPlayingStrategy;

    public Bot(char ch, int id, String name, BotDifficultyLevel botDifficultyLevel) {

        super(ch, id, name, PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
        botPlayingStrategy = BotPlayingFactory.getBotPlayingStrategy(botDifficultyLevel);
    }

    public BotDifficultyLevel getbotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public Move makeMove(Board board) {
        
        Move moveMade = botPlayingStrategy.makeMove(board);
        moveMade.setPlayer(this);
        return moveMade;
    }
}
