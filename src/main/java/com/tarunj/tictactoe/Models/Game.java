package com.tarunj.tictactoe.Models;

import java.util.List;

import com.tarunj.tictactoe.Strategies.WinningStrategy;

public class Game {

    private List<Player> players;
    private Board board;
    private List<Move> moves;
    private GameState gameState;
    private Player winner;
    private List<WinningStrategy> winningStrategies;
    private int nextPlayerToMoveIdx;

    public static class builder {
        
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

}
