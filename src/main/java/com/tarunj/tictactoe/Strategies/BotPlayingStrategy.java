package com.tarunj.tictactoe.Strategies;

import com.tarunj.tictactoe.Models.Board;
import com.tarunj.tictactoe.Models.Move;

public interface BotPlayingStrategy {
    
    public Move makeMove(Board board);
}
