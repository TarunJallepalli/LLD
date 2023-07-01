package com.tarunj.tictactoe.Controller;

import java.util.List;

import com.tarunj.tictactoe.Exceptions.BotCountMisMatchException;
import com.tarunj.tictactoe.Exceptions.CharacterCountMisMatchException;
import com.tarunj.tictactoe.Exceptions.PlayerCountMisMatchException;
import com.tarunj.tictactoe.Models.Game;
import com.tarunj.tictactoe.Models.Player;
import com.tarunj.tictactoe.Strategies.WinningStrategy;

public class GameController {
    
    public Game startGame(List<Player> players, List<WinningStrategy> winningStrategies, int boardDimension) throws PlayerCountMisMatchException, BotCountMisMatchException, CharacterCountMisMatchException {

        Game.Builder builder = Game.getBuilder(boardDimension, players, winningStrategies);
        return builder.build();
    }

    public void makeMove (Game game) {

        
    }

    public void printBoard(Game game) {


    }

    public void undoMove(Game game) {


    }

    public void getGameState(Game game) {


    }
    
    public void winner(Game gasme) {


    }

}
