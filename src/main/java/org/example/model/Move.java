package org.example.model;

import org.example.enums.CellState;

public class Move {
    public Player player;
    public Cell cell;

    public Move(Player player, Cell cell) {
        this.player = player;
        this.cell = cell;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public void undo(){
        Cell cell = this.getCell();
        cell.setSymbol('.');
        cell.setCellState(CellState.EMPTY);
    }

}
