package object.day8;

// 추상클래스 테스트

public class B15AbstractTest {
    public static void main(String[] args) {
        // Animal animal = new Animal(); // new 객체 생성 못합니다. => Animal은 추상 클래스이므로.

        // Anonymous Inner Type (익명의 내부 클래스) => 클래스 이름이 없는 내부 클래스 형식
        Animal animal = new Animal() { // 강요된 추상 메소드를 재정의하면서 내부 클래스 정의 (일회용)
            @Override
            public void sound() {
                System.out.println("익명으로 만들어진 동물 클래스 : 소리는 모름.");
            }
        };

        animal.sound();
        System.out.println("animal toString = " + animal.toString());

        Puppy puppy = new Puppy("푸들", "보라");
        puppy.sound();
        System.out.println("puppy toString = " + puppy.toString());
    }
}
