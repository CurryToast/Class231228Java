package object.day7;

/*  클래스의 상속
		ㄴ 자세하게(구체화된) 클래스를 만든다면 .. 삼각형,정사각형,직사각형,사다리꼴...
		ㄴ 구체화할 때 Shape 클래스를 상속. 부모 클래스 Shape은 모든 도형들의 공통적인 필드와 메소드를 정의.
		ㄴ 상속받는 자식 클래스는 부모 클래스의 생성자를 호출해서 부모의 필드값을 초기화합니다.
		ㄴ 자식 클래스는 부모 클래스의 메소드를 사용할 수 있습니다.
		ㄴ 자식 클래스는 부모 클래스의 필드값을 가져올 수 있습니다.
		ㄴ 자식 클래스는 부모 클래스의 메소드를 재정의(오버라이딩) 할 수 있습니다.

	↓ Shape 클래스는 추상적인 상태. 모든 도형을 대표하는 클래스로 정의하였습니다.
 */

public class Shape {
	public static final int MAX_WIDTH = 100;    // 상수 - 최대 너비를 정함.

	// 인스턴스 필드
	private String shapeName;	// 도형 이름
	private int width;			// 도형의 크기 중 너비
	private int height;			// 도형의 크기 중 높이
	protected String etc;
	int round; // 접근 한정자가 없는 경우

	public Shape() {
		// 아래 커스텀 생성자가 있을 때는 기본 생성자 사용하고 싶으면 직접 정의하기
		System.out.println("새로운 도형이 만들어졌습니다. 초기화가 필요합니다.");
	}

	// 인스턴스 필드값 초기화하는 생성자
	public Shape(String shapeName, int width, int height) {
		System.out.println(shapeName + " 객체 생성");
		this.shapeName = shapeName;
		this.width = width;
		this.height = height;
	}

	// 필드값을 리턴하는 getter 메소드
	public String getShapeName() {
		return shapeName;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	// setter 메소드 없음.('초기값을 바꿀수 없다'는 요구조건을 예시로 합니다.)
	// 변경 : shapeName만 setter가 필요해서 추가합니다.
	public void setShapeName(String shapeName) {
		this.shapeName = shapeName;
	}

	// 도형의 면적(넓이) 계산하는 메소드 (계산식은 너비 *높이)
	public int calculateArea() {
		return width * height;
	}

	// 자식 클래스들이 draw를 재정의해서 다른 메시지가 출력되게 만들 예정입니다.
	public void draw() {
		System.out.println("어떤 도형인지 아직 모릅니다.");
	}

	// final 메소드 - 재정의 할수 없는 메소드로 만들어야 할때 사용합니다.
	public final void print() {
		System.out.println("final 메소드 테스트 - " + shapeName + "의 너비:" + width + ", 높이:" + height + ", 면적:" + calculateArea());
	}

	protected void printProtected() {
		System.out.println("etc : " + this.etc);
	}

	void printRound() {
		System.out.println("round : " + this.round);
	}

}









