package object.test;

public class ExtendsTest extends Base {
    public static final String STATIC_STRING = "Static Extends Test";

    private int index;
    private char symbol;

    public ExtendsTest(String baseName, int address, double score, boolean isDummy) {
        super(baseName, address, score);
        this.isDummy = isDummy;
    }


    public int getIndex() {
        return index;
    }

    public char getSymbol() {
        return symbol;
    }


    public void setIndex(int index) {
        this.index = index;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public void setAccess(long[] access) {
        this.access = access;
    }


    @Override
    public void printIsDummy() {
        if (isDummy) {
            System.out.println("I'm Dummy");
        } else {
            super.printIsDummy();
        }
    }

    @Override
    public void showDatas() {
        if (isDummy) {
            for (int i = 0; i <= this.index; i++) {
                System.out.print(this.symbol);
            }
        } else {
            super.showDatas();
        }
    }
}
