// 작성자 : 임현범

package koreait.test;

public abstract class Product {
    protected String prdName;
    protected int price;

    public Product(String prdName, int price) {
        this.prdName = prdName;
        this.price = price;
    }

    public String getPrdName() {
        return prdName;
    }

    public int getPrice() {
        return price;
    }

    public abstract String sell(Object arg);
}
