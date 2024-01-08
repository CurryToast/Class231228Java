package object.test;

import object.day7.Shape;

public class Square extends Shape {
    public void setEtc(String etc) {
        this.etc = etc; // Square는 Shape의 자식이므로 접근 가능
    }

    // public void setRound(int round) {
    //     this.round = round; // Shape과 같은 패키지가 아니어서 접근 불가능
    // }

    @Override
    public void draw() {
        System.out.println("사각형 " + this.getShapeName() + " 를 그립니다.");
    }
}
