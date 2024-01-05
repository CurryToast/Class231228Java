package object.day6;

public class Cart {
    private String userid;
    private String[] productNames;
    private int[] prices;
    private int total_Money = 0;


    public int getTotal_Money() {
        return total_Money;
    }

    public String getUserid() {
        return userid;
    }

    public String[] getProductNames() {
        return productNames;
    }

    public int[] getPrices() {
        return prices;
    }


    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setProductNames(String[] productNames) {
        this.productNames = new String[productNames.length];
        for (int i = 0; i < productNames.length; i++) {
            this.productNames[i] = productNames[i];
        }
    }

    public void setPrices(int[] prices) {
        this.prices = new int[prices.length];
        for(int i = 0; i < prices.length; i++) {
            this.prices[i] = prices[i];
        }
    }

    // Setter는 total_Money가 대신함
    // public void setTotal_Money(int total_Money) {
    //     this.total_Money = total_Money;
    // }


    public void total_Money(int[] select) {
        int total_Money = 0;
        for(int item : select) {
            if (item < 0) {
                break;
            }

            total_Money += this.prices[item];
        }

        this.total_Money = total_Money;
    }
}
