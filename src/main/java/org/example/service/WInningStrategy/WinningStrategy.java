package org.example.service.WInningStrategy;

import org.example.model.Board;
import org.example.model.Move;

public interface WinningStrategy {
    boolean checkWinner(Board board, Move move);
}
