package object.test;

import object.day7.Diamond;

public class Base {
    public static final String STATIC_STRING = "Static Base";

    private String baseName;
    private int address;
    private double score;
    protected long[] access;
    protected Diamond diamond;
    protected boolean isDummy;


    public Base(String baseName, int address, double score) {
        this.baseName = baseName;
        this.address = address;
        this.score = score;
    }


    public void showDatas() {
        System.out.println(String.format("%s\t%d\t%f", this.baseName, this.address, this.score));
    }

    public void printIsDummy() {
        System.out.println("I'm not Dummy");
    }
}
