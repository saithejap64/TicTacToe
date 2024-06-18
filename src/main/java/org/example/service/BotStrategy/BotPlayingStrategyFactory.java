package org.example.service.BotStrategy;

import org.example.enums.BotDifficultyLevel;
import org.example.exception.GameOverException;
import org.example.model.Board;
import org.example.model.Cell;

public class BotPlayingStrategyFactory{
    public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel botDifficultyLevel){
        if(botDifficultyLevel == BotDifficultyLevel.RANDOM)
            return new RandomBotPlayingStrategy();

        return null;
    }
}
