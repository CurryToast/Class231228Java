package object.day6;

import java.util.Arrays;
import java.util.Scanner;

public class Omok {
    private OmokTile[] tiles;
    private int size;

    private int tileIndex(int row, int column) {
        return row + column + (this.size - 1) * row;
    }

    public Omok(int size) {
        this.size = size;
        this.tiles = new OmokTile[size * size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int index = i + j + (size - 1) * i;
                this.tiles[index].setIndex(i, j);
            }
        }
    }


    public void setFieldSymbol(int row, int column, char symbol) {
        OmokTile[tileIndex(row, column)].setSymbol(symbol);
    }

    public void printTable() {
        for (int i = 0; i < this.tiles.length; i++) {
            for (int j = 0; j < this.tiles.length; j++) {
                int index = i + j + (this.tiles.length - 1) * i;
                System.out.println(String.format("%c ", this.tiles[index].getSymbol()));
            }
        }
    }

    public void playOmok() {
        Scanner sc = new Scanner(System.in);
        String inputString;
        boolean boo = true;
        while (boo) {
            printTable();
            System.out.print("값 입력 >> ");
            inputString = sc.nextLine();
        }
    }
}

//        j=0             j=1       j=2       j=3       j=4
// i=0 => 0+0+4*0         0+1       0+2       0+3       0+4
// i=1 => i+j+(size-1)*i  1+1+4     1+2+4     1+3+4     1+4+4
// i=2 => 2+0+4*2         2+1+4+4   2+2+4+4   2+3+4+4   2+4+4+4
// i=3 => 3+0+4*3
// i=4 => 4+0+4*4