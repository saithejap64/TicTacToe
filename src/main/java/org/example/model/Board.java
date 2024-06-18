package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private List<List<Cell>>cells;

    public Board(int size) {
        this.size = size;
        cells=new ArrayList<>();

        for(int i=0;i<size;i++){
            cells.add(new ArrayList<>());
            for(int j=0;j<size;j++){
                cells.get(i).add(new Cell(i,j));
            }
        }
    }
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getCells() {
        return cells;
    }

    public void setCells(List<List<Cell>> cells) {
        this.cells = cells;
    }



    public Board(Board board){//used in addBoardState in Game Class
        int size=board.size;
        cells=new ArrayList<>();
        for(int i=0;i<size;i++){
            cells.add(new ArrayList<>());
            for(int j=0;j<size;j++){
                cells.get(i).add(new Cell(board.getCells().get(i).get(j)));
            }
        }
    }

    public void PrintBoard(){
        for(int i=0;i<size;i++) {
            for (Cell cell : cells.get(i)){
                cell.display();
            }
            System.out.println();
        }
    }
}
