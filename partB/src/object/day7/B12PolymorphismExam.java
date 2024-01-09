package object.day7;

import object.test.Square;

/*
 * 다형성이 어떻게 구현되는 것인지 확인하기
 * 자료구조가 필요합니다. 배열을 사용해 봅시다.
 */

public class B12PolymorphismExam {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[5];

        shapes[0] = new Diamond();
        shapes[0].setShapeName("다이아몬드1");

        shapes[1] = new Triangle("트라이앵글", 120, 40, 45);

        shapes[2] = new Square();
        shapes[2].setShapeName("스퀘어1");

        shapes[3] = new Diamond();
        shapes[3].setShapeName("다이아몬드2");

        shapes[4] = new Square();
        shapes[4].setShapeName("스퀘어2");

        // 다형성 : 자료구조에 저장된 객체가 하나의 타입(Shape)이지만 실행되는 draw 동작은 모두 다릅니다.
        for (int i = 0; i < shapes.length; i++) {
            System.out.println(i + "번 도형입니다.");
            shapes[i].draw();
            // 부모 타입으로 참조되는 객체들이 재정의된 draw() 메소드를 실행합니다.
            // 다형성은 메소드는 한가지를 통일해서 실행하나 결과는 여러 형태로 보이는 것입니다.
        }

        System.out.println("::::: 자식 객체의 실제 타입을 검사하는 instanceof 연산 :::::");
        for (int i = 0; i < shapes.length; i++) {
            System.out.println("\tshapes[i] instanceof Triangle ? " + (shapes[i] instanceof Triangle));
            System.out.println("\tshapes[i] instanceof Diamond ? " + (shapes[i] instanceof Diamond));
            System.out.println("\tshapes[i] instanceof Square ? " + (shapes[i] instanceof Square));
        }

        System.out.println("\n::::: 삼각형 Triangle 객체는 넓이를 구해서 출력하기 :::::");
        for (int i = 0; i < shapes.length; i++) {
            if (shapes[i] instanceof Triangle) {
                System.out.print(String.format("\t삼각형 %s의 넓이는 %d\n\t", shapes[i].getShapeName(), shapes[i].calculateArea()));
                ((Triangle)shapes[i]).printAngle(); // 반드시 실제 객체가 Triangle일때만 캐스팅해야 합니다.
            }
        }

        System.out.println("\n::::: 다이아몬드 Diamond 객체의 draw 실행하기");
        for (Shape shape : shapes) {
            if (shape instanceof Diamond) {
                System.out.print("\t");
                shape.draw();
            }
        }

        System.out.println("\n::::: 4인덱스 도형을 Triangle로 참조해서 코드 실행 :::::");
        shapes[4] = new Triangle("NULL", 80, 80, 8);
        for (Shape shape : shapes) {
            if (shape instanceof Triangle) {
                System.out.println(shape.getShapeName() + "는 삼각혐입니다. 넓이 : " + shape.calculateArea());
            }
        }

        // UpCasting
        Shape sh = new Diamond();
        // sh.iAmDiamond(); => Shape 타입이므로 실행 불가

        // DownCasting - sh의 실제 객체가 다운 캐스팅하려는 타입인지 검사 꼭 하기! - instanceof 연산자로 검사
        //             - sh의 실제 객체가 아닌 것(Triangle, Square)을 Diamond로 캐스팅하면 오류
        Diamond diamond = (Diamond)sh;
        diamond.iAmDiamond(); // 자식 객체의 인스턴스 메소드 iAmDiamond는 반드시 다운캐스팅 해야 실행 가능
    }
}
