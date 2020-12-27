package org.corda.year2020.model;

public class FlightPosition {
     int id;
     int row;
     int column;

    public FlightPosition(int row, int column, int id ) {
        this.id = id;
        this.row = row;
        this.column = column;
    }

    public int getId() {
        return id;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
