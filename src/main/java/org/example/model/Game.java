package org.example.model;

import org.example.enums.GameStatus;
import org.example.enums.PlayerType;
import org.example.exception.BotCountExceededException;
import org.example.exception.DuplicateSymbolFoundExcepion;
import org.example.exception.InvalidBoardSizeException;
import org.example.exception.InvalidPlayerCountException;
import org.example.service.WInningStrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private Player currentPlayer;
    private GameStatus gameStatus;
    private Player winner;
    private List<Move>moves;
    private List<Board>boardStates;
    private List<WinningStrategy> winningStrategies;

    private Game(int size, List<Player> players, List<WinningStrategy> winningStrategies) {

        this.board = new Board(size);
        // System.out.println("Hii..");
        this.players = players;
        this.currentPlayer =  players.get(0);
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.moves = new ArrayList<>();
        boardStates = new ArrayList<>();
        this.winningStrategies = winningStrategies;
    }

    public void undoTheMove(Move move){
        move.undo();
    }
    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }
    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }
    public List<Board> getBoardStates() {
        return boardStates;
    }

    public void addMove(Move move){
        moves.add(move);
    }

    public void addBoardState(){
        boardStates.add(new Board(board));
    }

    public boolean checkWon(){
        Move move=moves.get(moves.size()-1);
        boolean won=true;
        for(WinningStrategy winningStrategy1:winningStrategies){
            won =won && winningStrategy1.checkWinner(board,move);
        }
        return won;
    }

    public boolean checkDraw(){
        int size=board.getSize();
        return moves.size()==size*size;
    }
    public void updateGameStatus(){
        if(checkWon()){
            winner=currentPlayer;
            gameStatus=GameStatus.COMPLETED;
            System.out.println("Winner of the Game is:"+ winner.getName());
        }else if(checkDraw()){
            gameStatus= GameStatus.DRAW;
            System.out.println("Game Has Been Drawn");
        }
    }

    public static Builder getBuilder(){

        return new Builder();
    }
    public static class Builder{
        private int size;
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;

        public Builder setSize(int size) {
            this.size = size;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategy(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        private void validateBotCount() throws BotCountExceededException {
            int botCnt=0;
            for(Player player:players){
                if(player.getPlayerType().equals(PlayerType.BOT))
                    botCnt++;
            }
            if(botCnt>1 || botCnt==0)
                throw new BotCountExceededException("Bot count must be 1");
        }

        private void validateUniqueSymbols() throws DuplicateSymbolFoundExcepion {
            HashSet<Character> symbols=new HashSet<>();
            for(Player player:players){
                symbols.add(player.getSymbol());
            }
            if(symbols.size()< players.size())
                throw new DuplicateSymbolFoundExcepion("Duplicate Symbol is Not Allowed");
        }

        private void validateBoardSize() throws InvalidBoardSizeException {
            if(size<3)
                throw new InvalidBoardSizeException("Size of the Board Must be greater than or equal to 3");
        }

        private void validatePlayersCount() throws InvalidPlayerCountException {
            if(players.size()!=size-1)
                throw new InvalidPlayerCountException("Players count is Invalid");
        }

        private void validate() throws InvalidPlayerCountException, DuplicateSymbolFoundExcepion, InvalidBoardSizeException, BotCountExceededException {
            validatePlayersCount();
            validateBoardSize();
            validateUniqueSymbols();
            validateBotCount();
        }

        public Game Build() throws DuplicateSymbolFoundExcepion, InvalidPlayerCountException, InvalidBoardSizeException, BotCountExceededException {
            validate();
            return new Game(size,players,winningStrategies);
        }
    }
}
