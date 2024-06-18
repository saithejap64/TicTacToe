package org.example.model;

import org.example.enums.BotDifficultyLevel;
import org.example.enums.CellState;
import org.example.enums.PlayerType;
import org.example.exception.CellOccupiedException;
import org.example.exception.GameOverException;
import org.example.exception.InvalidCellEntryException;
import org.example.service.BotStrategy.BotPlayingStrategy;
import org.example.service.BotStrategy.BotPlayingStrategyFactory;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;

    public Bot(int id, char symbol, BotDifficultyLevel botDifficultyLevel) {
        super(id, "BOT" ,symbol, PlayerType.BOT);
        this.botDifficultyLevel=botDifficultyLevel;
    }

    public BotDifficultyLevel getDifficulty() {
        return botDifficultyLevel;
    }

    @Override
    public Move makeMove(Board board) throws InvalidCellEntryException, CellOccupiedException, GameOverException {
        BotPlayingStrategy botPlayingStrategy= BotPlayingStrategyFactory.getBotPlayingStrategy(botDifficultyLevel);
        Cell cell=botPlayingStrategy.makeMove(board);
        cell.setCellState(CellState.FILLED);
        cell.setSymbol(getSymbol());
        System.out.println(getName()+" played a move ");
        return new Move(this,cell);
    }
}
