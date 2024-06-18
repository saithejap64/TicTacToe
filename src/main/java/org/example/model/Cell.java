package org.example.model;
import org.example.enums.CellState;

public class Cell {
    private int row;
    private int col;
    private CellState cellState;
    private char Symbol;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.cellState=CellState.EMPTY;
        this.Symbol='.';
    }
    public Cell(Cell cell){//Used in Board Class Constructor
        this.row = cell.row;
        this.col = cell.col;
        this.cellState = cell.cellState;
        this.Symbol = cell.Symbol;
    }
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public char getSymbol() {
        return Symbol;
    }

    public void setSymbol(char symbol) {
        Symbol = symbol;
    }

    public void display(){
        if(Symbol=='.'){
            System.out.print("|   |");
        } else {
            System.out.print("| " + Symbol + " |");
        }
    }
}
