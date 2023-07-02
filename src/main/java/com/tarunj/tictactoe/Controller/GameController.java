package com.tarunj.tictactoe.Controller;

import java.util.List;

import com.tarunj.tictactoe.Exceptions.BotCountMisMatchException;
import com.tarunj.tictactoe.Exceptions.CharacterCountMisMatchException;
import com.tarunj.tictactoe.Exceptions.PlayerCountMisMatchException;
import com.tarunj.tictactoe.Models.Game;
import com.tarunj.tictactoe.Models.GameState;
import com.tarunj.tictactoe.Models.Player;
import com.tarunj.tictactoe.Strategies.WinningStrategy;

public class GameController {
    
    public Game startGame(List<Player> players, List<WinningStrategy> winningStrategies, int boardDimension) throws PlayerCountMisMatchException, BotCountMisMatchException, CharacterCountMisMatchException {

        Game.Builder builder = Game.getBuilder(boardDimension, players, winningStrategies);
        return builder.build();
    }

    public void makeMove (Game game) {

        game.makeMove();
    }

    public void printBoard(Game game) {

        game.printBoard();
    }

    public void undoMove(Game game) {

        game.undoMove();
    }

    public GameState getGameState(Game game) {

        return game.getGameState();
    }
    
    public String getWinner(Game game) {

        return game.getWinner().getName();
    }

}
