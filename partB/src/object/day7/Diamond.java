package object.day7;

// Shape 클래스 상속 예시2

public class Diamond extends Shape {
    protected void setEtc(String etc) {
        this.etc = etc;
    }

    public void setRound(int round) {
        this.round = round;
    }

    @Override
    public void draw() {
        System.out.println("다이아몬드 " + this.getShapeName() + " 를 그립니다.");
    }


    // 자식 클래스가 정의한 인스턴스 메소드 - Diamond 타입으로 선언한 참조 변수만 실행할 수 있음.
    public void iAmDiamond() {
        System.out.println("나는 다이아몬드 ~반짝반짝!!");
    }
}

/*
 * 접근 한정자 (Access Modifier)
 * public => 모두에게 공개
 * private => 모두에게 비공개
 * protected => 같은 패키지 클래스 및 자식에게만 공개
 * 아무것도 안씀 (default) => 같은 패키지 클래스에게만 공개 (거의 사용하지 않습니다.)
 */