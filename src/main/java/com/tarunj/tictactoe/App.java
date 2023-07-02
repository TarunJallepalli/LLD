package com.tarunj.tictactoe;

import java.util.ArrayList;
import java.util.List;

import com.tarunj.tictactoe.Controller.GameController;
import com.tarunj.tictactoe.Models.Bot;
import com.tarunj.tictactoe.Models.BotDifficultyLevel;
import com.tarunj.tictactoe.Models.Game;
import com.tarunj.tictactoe.Models.GameState;
import com.tarunj.tictactoe.Models.Player;
import com.tarunj.tictactoe.Models.PlayerType;
import com.tarunj.tictactoe.Strategies.ColumnWinningStrategy;
import com.tarunj.tictactoe.Strategies.LeftDiagonalWinningStrategy;
import com.tarunj.tictactoe.Strategies.RightDiagonalWinningStrategy;
import com.tarunj.tictactoe.Strategies.RowWinningStrategy;
import com.tarunj.tictactoe.Strategies.WinningStrategy;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        GameController gameController = new GameController();
        //Scanner sc = new Scanner(System.in);
        
        try {

            List<Player> players = new ArrayList<>();
            players.add(new Player('x', 0, new String("Tarun"), PlayerType.HUMAN));
            players.add(new Bot('o', 1, new String("GPT"), BotDifficultyLevel.EASY));

            List<WinningStrategy> winningStrategies = new ArrayList<>(); 
            winningStrategies.add(new RowWinningStrategy());
            winningStrategies.add(new ColumnWinningStrategy());
            winningStrategies.add(new LeftDiagonalWinningStrategy());
            winningStrategies.add(new RightDiagonalWinningStrategy());

            int boardDimension = players.size() + 1;

            Game game = gameController.startGame(players, winningStrategies, boardDimension);

            while(gameController.getGameState(game).equals(GameState.IN_PROGRESS)) {

                gameController.printBoard(game);

                gameController.makeMove(game);
            }

            if(gameController.getGameState(game).equals(GameState.WON))
                System.out.println(gameController.getWinner(game) + " has won the game");
            

            else if(gameController.getGameState(game).equals(GameState.DRAWN)) 
                System.out.println("The Game has been DRAWN");
        }

        catch (Exception e){

            System.out.println(e);
            System.out.println("Something went Wrong");
        }
    }
}
