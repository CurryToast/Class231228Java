package basic.day2;

//char 문자형 데이터 연습
public class A07CharacterTest {

	public static void main(String[] args) {
		char c1 = 'A';
		char c2 = 65;
		
		System.out.println("c1 : " + c1);
		System.out.println("c2 : " + c2);
		System.out.println("======문자의 코드값을 알고 싶으면 정수로 자동 캐스팅====");
		
		int code1 = c1; // c1은 'A' 를 int 로 자동 캐스팅하면 65
		System.out.println("int로 캐스팅한 c1 : " + code1);
		code1 += 1;
		System.out.println("======덧셈연산한 코드값의 문자를 알고 싶으면 문자로 강제 캐스팅====");
		System.out.println("문자 : " + (char)code1); // int를 char로 강제 캐스팅. 'B'

		char c3 = '가';
		char c4 = '\uac00'; // \\u 는 유니코드를 나타내는 이스케이프 문자 (16진수로 표시). '가'
		char c5 = 44032; // ac00 16진수에 대한 10진수 정수값
		char c6 = '힣'; // 한글 마지막 문자
		System.out.println("c3 : " + c3);
		System.out.println("c4 : " + c4);
		System.out.println("c5 : " + c5);
		System.out.println("'가' 문자의 유니코드값 (10진수) :" + (int)c3);

		System.out.println("=====c3,c4,c5 변수의 문자가 아닌 코드값을 출력해보기======");
		System.out.println(String.format("16진수 int c5 : %X", (int)c5));

		int code6 = c6;
		System.out.println("한글 마지막 문자 c6 : " + c6);
		System.out.println("한글 마지막 문자 코드값 code6 : " + code6);
		System.out.println("한글 유니코드 문자는 총 " + (code6 - 44032 + 1) + "개 입니다.");
		
		int code3 = c3;
		System.out.println("code3 : " + code3);
		System.out.println("문자로 캐스팅한 code3 : " + (char)code3); //int를 char로 강제 캐스팅. '각'
		
		code3++;
		System.out.println("변경된 code3 : " + code3);
		System.out.println("변경된 code3 문자 : " + (char)code3); // int를 char로 강제 캐스팅. '각'
		
		c3++;
		System.out.println("변경된 c3 : " + c3);
		System.out.println("변경된 c3 문자 : " + (char)c3); // int를 char로 강제 캐스팅. '갂'
		
		// 문자형으로는 덧셈이 오류. 1 리터럴은 int 정수이므로 char 변수 c1 값과 바로 덧셈 못함.
		// c1 = c1 + 1; => 불가능
		// c1++ => 증가연산자는 가능. 자동으로 캐스팅하여 덧셈.
	}

}
