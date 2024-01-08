package object.day7;

public class B10DiamondTest {
    public static void main(String[] args) {
        Diamond diamond = new Diamond();
        System.out.println("다이아몬드 너비 : " + diamond.getWidth());
        System.out.println("다이아몬드 높이 : " + diamond.getHeight());
        System.out.println("다이아몬드 넓이 : " + diamond.calculateArea());
        diamond.print();

        diamond.round = 314;
        diamond.etc = "test";
        System.out.println("diamond.round 변경된 내용 확인 : " + diamond.round);
        System.out.println("diamond.etc 변경된 내용 확인 : " + diamond.etc);

        diamond.setEtc("TEST");
        System.out.println("diamond.etc 변경된 내용 확인 : " + diamond.etc);

        diamond.printProtected();
        diamond.printRound();
    }
}
