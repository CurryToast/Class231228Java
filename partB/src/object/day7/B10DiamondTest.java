package object.day7;

public class B10DiamondTest {
    public static void main(String[] args) {
        Diamond diamond = new Diamond();
        System.out.println("다이아몬드 너비 : " + diamond.getWidth());
        System.out.println("다이아몬드 높이 : " + diamond.getHeight());
        System.out.println("다이아몬드 넓이 : " + diamond.calculateArea());
        diamond.print();
    }
}
