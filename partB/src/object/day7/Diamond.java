package object.day7;

// Shape 클래스 상속 예시2

public class Diamond extends Shape {
    public void setEtc(String etc) {
        this.etc = etc;
    }
}

/*
 * 접근 한정자 (Access Modifier)
 * public => 모두에게 공개
 * private => 모두에게 비공개
 * protected => 자식에게만 공개
 * 아무것도 안씀 => 같은 패키지 클래스에게만 공개 (거의 사용하지 않습니다.)
 */