package org.example.model;

import org.example.enums.CellState;
import org.example.enums.PlayerType;
import org.example.exception.CellOccupiedException;
import org.example.exception.GameOverException;
import org.example.exception.InvalidCellEntryException;

import java.util.Scanner;

public class Player {
    public int id;
    public String Name;
    public char Symbol;
    public PlayerType playerType;

    public Player(int id, String name, char symbol) {
        this(id,name,symbol,PlayerType.HUMAN);
    }

    public Player(int id, String name, char symbol, PlayerType playerType) {
        this.id = id;
        this.Name = name;
        this.Symbol = symbol;
        this.playerType = playerType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public char getSymbol() {
        return Symbol;
    }


    public PlayerType getPlayerType() {
        return playerType;
    }


    private int getRowInput(){
        Scanner sc=new Scanner(System.in);
        System.out.println(Name + " Enter the Row:");
        return sc.nextInt();
    }

    private int getColInput(){
        Scanner sc=new Scanner(System.in);
        System.out.println(Name +" Enter the Column");
        return sc.nextInt();
    }

    //row column validation & Cell (Filled/Empty) Validation
    private void validateMove(Board board,int row,int col) throws InvalidCellEntryException, CellOccupiedException {
        if(row<0 || row>=board.getSize() || col<0 || col>board.getSize())
            throw new InvalidCellEntryException("Invalid Entry !!");
        Cell cell=board.getCells().get(row).get(col);
        if(cell.getCellState().equals(CellState.FILLED)){
            throw new CellOccupiedException("Cell is Already Occupied");
        }
    }

    public Move makeMove(Board board) throws InvalidCellEntryException, CellOccupiedException, GameOverException {
        int row=getRowInput();
        int col=getColInput();

        validateMove(board,row,col);
        Cell cell=board.getCells().get(row).get(col);
        cell.setSymbol(this.getSymbol());
        cell.setCellState(CellState.FILLED);
        return new Move(this,cell);
    }
}
