package org.example.service.BotStrategy;

import org.example.exception.GameOverException;
import org.example.model.Board;
import org.example.model.Cell;

public interface BotPlayingStrategy {
    Cell makeMove(Board board) throws GameOverException;
}
