package object.day6;

import java.util.Arrays;

public class Product {
    private String productName;
    private int price;
    private String company;
    private String[] etc;

    public Product(String productName, int price, String company, String[] etc) {
        this.productName = productName;
        this.price = price;
        this.company = company;
        this.etc = etc;
    }


    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public String getCompany() {
        return company;
    }

    public String[] getEtc() {
        return etc;
    }


    // 모든 필드 값을 이용해서 문자열을 만들어 리턴
    public String getData() {
        return String.format("%7s\t %d\t %5s\t%s", this.productName, this.price, this.company, Arrays.toString(this.etc));
    }
}
