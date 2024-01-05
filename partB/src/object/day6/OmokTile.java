package object.day6;

public class OmokTile {
    private int row;
    private int column;
    private char symbol;

    public OmokTile() {
        this.symbol = '+';
    }


    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public char getSymbol() {
        return symbol;
    }


    public void setIndex(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}
