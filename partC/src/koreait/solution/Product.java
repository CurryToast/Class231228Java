package koreait.solution;

// 2
public abstract class Product {
    protected int price;
    // 1
    protected String prdName;

    // 2
    public abstract String sell(Object object);

    @Override
    public String toString() {
        return  "prdName = " + prdName + ", price = " + price;
    }
}
