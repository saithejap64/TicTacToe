package org.example.service.WInningStrategy;

import org.example.model.Board;
import org.example.model.Move;
import org.example.model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NormalWinningStrategy implements WinningStrategy{
    private int dimension;
    private List<Map<Character,Integer>> rowMaps;   //character and its Count
    private List<Map<Character,Integer>> colMaps;
    private Map<Character,Integer> forwardDiagonalMap;
    private Map<Character,Integer> backwardDiagonalMap;


    public NormalWinningStrategy(int dimension) {
        this.dimension = dimension;
        this.rowMaps = new ArrayList<>();
        this.colMaps = new ArrayList<>();

        for(int i=0;i<dimension;i++){
            rowMaps.add(new HashMap<>());
            colMaps.add(new HashMap<>());
        }
        forwardDiagonalMap = new HashMap<>();
        backwardDiagonalMap = new HashMap<>();
    }

    private Boolean checkIfRowWon(Character Symbol, int row){//row Win
        rowMaps.get(row).put(Symbol,rowMaps.get(row).getOrDefault(Symbol,0)+1);
        return rowMaps.get(row).get(Symbol)==dimension;
    }

    private boolean checkIfColumnWon(Character Symbol,int col){//column Win
        colMaps.get(col).put(Symbol,colMaps.get(col).getOrDefault(Symbol,0)+1);
        return colMaps.get(col).get(Symbol)==dimension;
    }

    private boolean checkIfForwardDiagonalWin(Character Symbol,int row,int col){
        if(row+col!=dimension-1)
            return false;
        forwardDiagonalMap.put(Symbol,forwardDiagonalMap.getOrDefault(Symbol,0)+1);
        return forwardDiagonalMap.get(Symbol)==dimension;
    }

    private boolean checkIfBackwardDiagonalWin(Character Symbol,int row,int col){
        if(row!=col)
            return false;
        backwardDiagonalMap.put(Symbol,backwardDiagonalMap.getOrDefault(Symbol,0)+1);
        return backwardDiagonalMap.get(Symbol)==dimension;
    }


    @Override
    public boolean checkWinner(Board board, Move move) {
        Player player=move.getPlayer();
        Character Symbol=player.getSymbol();
        int row=move.getCell().getRow();
        int col=move.getCell().getCol();

        return checkIfRowWon(Symbol,row) || checkIfColumnWon(Symbol,col)
                || checkIfBackwardDiagonalWin(Symbol,row,col)
                || checkIfForwardDiagonalWin(Symbol,row,col);
    }
}
