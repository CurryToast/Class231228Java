package object.day6;

import java.util.Arrays;

public class Omok {
    private OmokTile[] tiles;

    public Omok(int size) {
        this.tiles = new OmokTile[size * size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int index = i + j + (size - 1) * i;
                this.tiles[index].setIndex(i, j);
            }
        }
    }
}

//        j=0             j=1       j=2       j=3       j=4
// i=0 => 0+0+4*0         0+1       0+2       0+3       0+4
// i=1 => i+j+(size-1)*i  1+1+4     1+2+4     1+3+4     1+4+4
// i=2 => 2+0+4*2         2+1+4+4   2+2+4+4   2+3+4+4   2+4+4+4
// i=3 => 3+0+4*3
// i=4 => 4+0+4*4