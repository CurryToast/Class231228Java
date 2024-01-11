package collection.day10;

/*
 * 아래 Member 클래스는 생성될 때 초기화하면 변경 못합니다.
 *                              hashCode, equals 재정의.
 * 이러한 객체를 VO (Value Object) 라고 합니다.
 */

public class Member {
    private String name;
    private int age;

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "Member [name=" + name + ", age=" + age + "]";
    }

    // 중요 : 객체의 동일성(같은 객체인지)을 검사하기 위해서 hashCode 메소드, equals 메소드를 재정의하여 사용.
    //              -> 해시코드 값이 같고 인스턴스 필드의 내용이 같으면 '동일한 객체'다.

    // 인스턴스 필드 값으로 해시코드 만드는 메소드 => 필드 값이 같으면 해시코드가 동일함
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + age;
        return result;
    }


    // 대상이 되는 obj와 현재 this 객체의 인스턴스 필드 값이 모두 같으면 참 리턴
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Member other = (Member) obj;
        if (name == null) {
            return (other.name == null);
        } else if (!name.equals(other.name))
            return false;
        if (age != other.age)
            return false;
        return true;
    }

}
