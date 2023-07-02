package com.tarunj.tictactoe.Strategies;

import com.tarunj.tictactoe.Models.BotDifficultyLevel;

public class BotPlayingFactory {

    public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel botDifficultyLevel) {
        return new EasyBotPlayingStrategy();
    }
}
