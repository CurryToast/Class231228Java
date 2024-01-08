package object.day7;

// Shape과 Triangle을 객체 생성하고 메소드 테스트 해보세요.

public class B07ShapeMain {
    public static void main(String[] args) {
        Shape sh = new Shape("Shape", 100, 100);
        Triangle tr = new Triangle("Triangle", 80, 60, 90);

        System.out.println("\n::::: 재정의 메소드 실행 확인 :::::");
        System.out.println(sh.getShapeName() + "의 넓이 : " + sh.calculateArea());
        System.out.println(tr.getShapeName() + "의 넓이 : " + tr.calculateArea());

        System.out.println("\n::::: 부모가 정의한 메소드 :::::");
        sh.print();
        tr.print();

        System.out.println("\n::::: 부모가 정의한 메소드를 자식이 실행할 수 있는지 :::::");
        System.out.println("세모 넓이 : " + tr.getWidth());
        System.out.println("세모 높이 : " + tr.getHeight());
        System.out.println("세모 각도 : " + tr.getAngle());

        System.out.println("\n::::: 자식이 정의한 메소드 :::::");
        tr.printAngle();

        // 상속에서의 변수 참조 타입 - 자식 클래스 타입, 부모 클래스 타입
        System.out.println("\n::::: 클래스 타입 캐스팅 :::::");
        // 1) 자식 객체를 부모 타입으로 참조하기
        Shape temShape = new Triangle("임시 도형", 7, 8, 13);
        // temShape.printAngle();
        temShape.print();
        System.out.println("부모 타입 참조이나 객체의 실체는 Triangle이므로 너비는 재정의 메소드로 실행됩니다.\n");

        // 2) 부모 객체를 자식 타입으로 참조 가능?? => 불가능
        // 부모 객체를 자식 타입으로 참조하기 위해 강제 캐스팅
        System.out.println("임시 삼각형 => 강제 캐스팅은 했으나 Triangle에 필요한 인스턴스 필드가 안만들어져서 오류 발생");
        Triangle teTriangle = (Triangle) new Shape("임시 삼각형", 8, 10);
        teTriangle.print();
        teTriangle.printAngle();
    }
}
