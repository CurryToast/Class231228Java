package object.day5;

import java.util.Arrays;

public class MyClass2 {
    // 인스턴스 필드 - 객체를 생성해서 사용
    // private 키워드 : 현재 클래스 외에 다른 클래스에서 사용 못함
    private String field1;
    private int field2;
    private double[] field3;


    // private 필드값을 가져오는 메소드 : getter
    public String getField1() {
        return field1;
    }

    public int getField2() {
        return field2;
    }

    public double[] getField3() {
        // getField3의 리턴값을 바로 저장한 외부의 배열이 변경되도 field3가 변경되지 않도록 함
        return Arrays.copyOf(field3, field3.length);
    }


    // private 필드값을 저장하는 메소드 : setter
    public void setField1(String f1) {
        field1  = f1;
    }

    public void setField2(int f2) {
        field2 = f2;
    }

    public void setField3(double[] f3) {
        // setField3의 인자로 전달한 외부 배열 f3이 변경되도 field3가 변경되지 않도록 함 
        field3 = new double[f3.length];
        for(int i = 0; i < f3.length; i++) {
            field3[i] = f3[i];
        }
    }

    // field3의 특정 인덱스의 값을 저장하는 setter
    public void setField3(double d, int i) {
        if (field3 == null) { // field3가 아직 null일때
            field3 = new double[i + 1];
            field3[i] = d;

            return;
        }
        
        if (i >= field3.length) { // 기존 field3의 크기를 넘어선 곳에 값을 저장할 때
            double[] temp = Arrays.copyOf(field3, i + 1);
            temp[i] = d;
            field3 = temp;

            return;
        }

        field3[i] = d;
    }


    // 모든 인스턴스 필드 값을 출력하는 메소드
    public void printData() {
        System.out.println(String.format("field1 = %s, field2 = %d, field3 = %s\n", field1, field2, Arrays.toString(field3)));
    }
}
