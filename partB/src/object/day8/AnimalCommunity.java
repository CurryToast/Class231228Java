package object.day8;

public class AnimalCommunity {
	public static void main(String[] args)  {
		System.out.println("여기는 유기동물 분양소입니다.");
		Animal[] animals = new Animal[10];
		animals[0] = new Puppy("푸들이","브라운");
		animals[1] = new Cat("그레이");
		animals[2] = new Rabbit();
		animals[2].setColor("화이트");
		animals[3] = new Puppy("말티즈","화이트");

		// 퀴즈 : 아래 객체를 배열 요소에 대입했습니다. 수정이 필요한 코드는??
		animals[7] = new Animal() {
			static final String TYPE = "새";

			@Override
			public void sound() {
				System.out.println("앵무새는 안녕~~ 하고 말합니다.");
			}

			@Override
			public String toString() {
				return TYPE + " [color = " + color + ", name = " + name + "]";
			}
		};
		animals[7].setName("앵무새");
		animals[7].setColor("빨강");

		System.out.println("\n[[반려동물 목록을 보여드리겠습니다.]] \n");
		for(int i = 0; i < animals.length; i++) {
			if(animals[i] != null) {
				animals[i].sound();
			}
		}
			
	    // 모모회원이 동물 보호소의 모든 동물들을 분양 받을 수 있는지 셀프 체크
	    // 강아지는 15세이상, 고양이는 18세이상, 토끼는 13세 이상, 그 외에 동물은 20세 이상만 분양받을 수 있습니다.
		// 		ㄴ Member 클래스의 isAdopt 메소드에서 사용하는 로직 => instanceof 연산 사용
		
		String name="모모";
		int age = 17;
	    Member member = new Member(age, name);
		
		StringBuilder sb = new StringBuilder(name); // String은 불변객체(문자열 변경 못함). StringBuilder는 가변객체(문자열 변경 가능)
		sb.append(" 회원님 \n"); // message += " 회원님 \n" 과 동일
		boolean result;
		for(int i = 0 ; i < animals.length; i++) {
			// if (animals[i] == null) { continue; }
			if(animals[i] != null) {
				result = member.isAdopt(animals[i]);
				sb.append(animals[i].toString());

				sb.append(result ? "  😃 분양 가능합니다. \n" : "  😓 분양 자격이 안됩니다.\n");
			}
		}

		System.out.println("\n" + sb.toString());
	}
	
}







