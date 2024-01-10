package object.test;

public class IntClassSizeCompare implements Comparable<IntClassSizeCompare> {
    private int id;
    private int num;

    public IntClassSizeCompare(int id, int num) {
        this.id = id;
        this.num = num;
    }

    public int getId() {
        return id;
    }

    public int getNum() {
        return num;
    }

    @Override
    public int compareTo(IntClassSizeCompare o) {
        return o.id - this.id;
    }

    @Override
    public String toString() {
        return String.format("[id: %d, num: %d]\t", this.id, this.num);
    }
}
