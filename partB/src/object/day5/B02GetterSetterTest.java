package object.day5;

public class B02GetterSetterTest {
    public static void main(String[] args) {
        String message = "나는 바보다";
        int iValue = 999;
        double[] dArray = {81.8, 92.6, 55.7};
        MyClass2 babo = new MyClass2();

        babo.setField3(77.77, 3);
        babo.printData();

        babo.setField1(message);
        babo.setField2(iValue);
        babo.setField3(dArray);
        babo.printData();

        babo.setField3(19.35, 4);
        babo.printData();

        babo.setField3(100, 2);
        babo.printData();

        double[] temp = babo.getField3();
        temp[2] = 3.1415;
        babo.printData();
    }
}
