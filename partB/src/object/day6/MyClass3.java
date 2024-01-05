package object.day6;

public class MyClass3 {
    // 인스턴스 필드 : 클래스 내부에서 사용가능한 전역 변수
    private String field1;
    private int field2;
    private double[] field3;


    public String getField1() {
        return this.field1; // this는 현재 자신 객체를 뜻하는 변수. getter에서는 생략하고도 쓸 수 있습니다.
    }

    public int getField2() {
        return this.field2;
    }

    public double[] getField3() {
        return this.field3;
    }


    public void setField1(String field1) { // 인자로 사용된 field1은 setField1 메소드의 지역 변수
        this.field1 = field1; // 현재 객체의 field1 값에 인자 field1 대입하기
    }

    public void setField2(int field2) {
        this.field2 = field2;
    }

    public void setField3(double[] field3) {
        this.field3 = field3;
    }
}
