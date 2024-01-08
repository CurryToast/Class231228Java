package object.test;

public class ExtendsTestMain {
    public static void main(String[] args) {
        ExtendsTest[] test = new ExtendsTest[(int)(Math.random()*10) + 3];
        for (int i = 0; i < test.length; i++) {
            test[i] = new ExtendsTest(String.format("%d-%c-%s", i, i, Base.STATIC_STRING), (int)(Math.random()*100), Math.random()*100, (int)(Math.random()*100)%3 == 0);
            test[i].showDatas();
            test[i].printIsDummy();
            System.out.println();
        }
    }
}
