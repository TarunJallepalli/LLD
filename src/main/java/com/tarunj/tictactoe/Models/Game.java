package com.tarunj.tictactoe.Models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.tarunj.tictactoe.Exceptions.BotCountMisMatchException;
import com.tarunj.tictactoe.Exceptions.CharacterCountMisMatchException;
import com.tarunj.tictactoe.Exceptions.PlayerCountMisMatchException;
import com.tarunj.tictactoe.Strategies.WinningStrategy;

public class Game {

    private List<Player> players;
    private Board board;
    private List<Move> moves;
    private GameState gameState;
    private Player winner;
    private List<WinningStrategy> winningStrategies;
    private int nextPlayerToMoveIdx;

    private Game(int boardDimension, List<Player> players, List<WinningStrategy> winningStrategies) {

        this.players = players;
        this.board = new Board(boardDimension);
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
        this.winningStrategies = winningStrategies;
        this.nextPlayerToMoveIdx = 0;
    }

    public static Builder getBuilder(int boardDimension, List<Player> players, List<WinningStrategy> winningStrategies) {
        return new Builder(boardDimension, players, winningStrategies);
    }

    public static class Builder {
        
        int boardDimension; 
        List<Player> players;
        List<WinningStrategy> winningStrategies;

        public Builder(int boardDimension, List<Player> players, List<WinningStrategy> winningStrategies) {

            this.boardDimension = boardDimension;
            this.players = players;
            this.winningStrategies = winningStrategies;
        }

        public void validatePlayerCount(int boardDimension, List<Player> players) throws PlayerCountMisMatchException {

            if(players.size() != boardDimension-1) throw new PlayerCountMisMatchException();
        }

        public void validateBotCount(List<Player> players) throws BotCountMisMatchException {

            int botCount = 0;

            for(Player player : players) {
                if(player.getType() == PlayerType.BOT) ++botCount;
            }

            if(botCount > 1) throw new BotCountMisMatchException();
        }

        public void validatePlayerCharacters(List<Player> players) throws CharacterCountMisMatchException {

            HashSet<Character> hset = new HashSet<>();

            for(Player player : players) {
                
                if(!hset.contains(player.getCh())) hset.add(player.getCh());
                else throw new CharacterCountMisMatchException();
            }
        }



        public void validate(int boardDimension, List<Player> players) throws PlayerCountMisMatchException, BotCountMisMatchException, CharacterCountMisMatchException {

            validatePlayerCount(boardDimension, players);
            validateBotCount(players);
            validatePlayerCharacters(players);
        } 

        public Game build() throws PlayerCountMisMatchException, BotCountMisMatchException, CharacterCountMisMatchException {

            validate(boardDimension, players);
            return new Game(boardDimension, this.players, this.winningStrategies);
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public int getNextPlayerToMoveIdx() {
        return nextPlayerToMoveIdx;
    }

    public void setNextPlayerToMoveIdx(int nextPlayerToMoveIdx) {
        this.nextPlayerToMoveIdx = nextPlayerToMoveIdx;
    }

    public void printBoard() {
        board.printBoard();
    }

    public void makeMove() {

        Player currPlayer = players.get(nextPlayerToMoveIdx);
        System.out.println("This is " + currPlayer.getName() + "'s turn to move.");

        Move moveMade = currPlayer.makeMove(board);
        int row = moveMade.getCell().getRow(), col = moveMade.getCell().getCol();

        if(!validateMove(row, col)) {
            
            System.out.println("Please enter a valid move");
            return ;
        }

        Cell currCell = board.getBoard().get(row).get(col);
        currCell.setPlayer(currPlayer);
        currCell.setCellState(CellState.FILLED);

        Move move = new Move(currCell, currPlayer); 
        moves.add(move);
        nextPlayerToMoveIdx = (nextPlayerToMoveIdx + 1) % players.size();

        checkGameState(move);
    }

    private void checkGameState(Move move) {

        for(WinningStrategy winningStrategy : winningStrategies) {

            if(winningStrategy.checkWinner(board, move)) {

                setGameState(GameState.WON);
                setWinner(move.getPlayer());
                return ;
            }
        }

        if(moves.size() == board.getSize() * board.getSize())
            setGameState(GameState.DRAWN);
    }

    private boolean validateMove(int row, int col) {

        if(row >= board.getSize() || row < 0) return false;
        if(col >= board.getSize() || col < 0) return false;

        return (board.getBoard().get(row).get(col)).getCellState().equals(CellState.EMPTY);
    }

}
