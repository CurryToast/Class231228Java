package object.day8;

public class Member {
    private int age;
    private String name;

    public Member(int age, String name) {
        this.age = age;
        this.name = name;
    }


    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }


    // 다형성 예시 : 메소드 인자가 부모 타입일때, 실제 객체는 여러 자식 객체가 될 수 있습니다.
    public boolean isAdopt(Animal animal) {
        boolean isAdopt;
        if (animal instanceof Puppy) {
            isAdopt = this.age >= 15;
        } else if (animal instanceof Cat) {
            isAdopt = this.age >= 18;
        } else if (animal instanceof Rabbit) {
            isAdopt = this.age >= 13;
        } else {
            isAdopt = this.age >= 20;
        }

        return isAdopt;
    }
}
