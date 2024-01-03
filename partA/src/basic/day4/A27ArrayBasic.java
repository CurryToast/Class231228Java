package basic.day4;

import java.util.Scanner;

//배열 기본
public class A27ArrayBasic {
	public static void main(String[] args) {
		// int age=23;  과 같은 변수선언 1개당 1개의 메모리 할당.
		// 배열은 여러개의 데이터를 저장할 수 있는 변수.  저장할 데이터의 형식/이름/데이터의 개수(할당 받는 메모리 크기)를 선언해야 함.
		int[] arr1 = {34,56,78,89,65};	// 저장할 값 초기화 //인덱스는 0부터 4
		int[] arr2 = new int[3];	//초기값은 기본값 0 , 정수 10개 (40바이트 할당), 인덱스 0~9

		// 배열의 주요 속성 : length 는 배열의 길이(개수)를 갖습니다.
		System.out.println("==인덱스 직접 지정해서 arr1 배열 요소값 출력하기 ==");
		System.out.println("i=0, arr1[0]=" + arr1[0]);
		System.out.println("i=1, arr1[1]=" + arr1[1]);
		System.out.println("i=2, arr1[2]=" + arr1[2]);
		System.out.println("i=3, arr1[3]=" + arr1[3]);
		System.out.println("i=4, arr1[4]=" + arr1[4]);

		// 배열에 저장된 값은 성적,포인트,이름 등등 같은 의미를 갖는 데이터들이며 따라서 처리 해야할 동작도 같습니다. => 반복문 필수
		System.out.println("\n~~~~~1. 반복문으로 arr1 배열 요소값 출력하기 ~~~~~");
		printArray(arr1);

		System.out.println("\n~~~~~2. arr1 배열의 합계 구하기 ~~~~~");
		System.out.println("arr1 배열의 합계: " + sumOfArray(arr1));

		System.out.println("\n~~~~~3. arr1 배열의 70이상 값 개수 구하기 ~~~~");
		System.out.println(String.format("\narr1 배열의 70 이상 값의 개수는 %d개.", checkBigValueOfArray(arr1, 70)));

		System.out.println("\n==인덱스 직접 지정해서 arr2 배열 요소값 출력하기 ==");
		System.out.println("i=0, arr2[0]=" + arr2[0]);
		System.out.println("i=1, arr2[1]=" + arr2[1]);
		System.out.println("i=2, arr2[2]=" + arr2[2]);
		System.out.println("\n~~~~~4. arr2 배열에 키보드 입력으로 값 저장하기~~~~~");
		scanArray(arr2);

		System.out.println("\n~~~~~ 5. 반복문으로 arr2 배열 요소값 출력하기 ~~~~~");
		printArray(arr2);

		System.out.println("\n" + arr2); // [I@b4c966a

		System.out.println("\n~~~~~6. arr2 배열의 60이하 값 개수 구하기 ~~~~");
		System.out.println(String.format("\narr2 배열의 60 이하 값의 개수는 %d개.", checkSmallValueOfArray(arr2, 60)));

		System.out.println("\n~~~~~7. arr2 배열의 값들 중 가장 큰 값과 가장 작은 값 구하기 ~~~~");
		System.out.println(String.format("가장 큰 값: %d", checkMaxinArray(arr2)));
		System.out.println(String.format("가장 작은 값: %d", checkMininArray(arr2)));

	}

	// 배열 arr의 값들의 합을 구하는 메소드
	public static int sumOfArray(int[] arr) { // 전달받은 배열 주소로 데이터를 가져오기 합니다.
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}

		return sum;
	}

	// 배열 arr의 값 중에서 n 이상인 값의 개수를 구하는 메소드
	public static int checkBigValueOfArray(int[] arr, int n) {
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] >= n) {
				count++;
			}
		}

		return count;
	}

	// 배열 arr의 값 중에서 n 이하인 값의 개수를 구하는 메소드
	public static int checkSmallValueOfArray(int[] arr, int n) {
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] <= n) {
				count++;
			}
		}

		return count;
	}

	// 배열 arr의 값들을 출력하는 메소드
	public static void printArray(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.println(String.format("%d번째 요소 값: %d", i, arr[i]));
		}
	}

	// 배열 arr의 값들을 입력받는 메소드
	public static void scanArray(int[] arr) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < arr.length; i++) {
			System.out.print(String.format("arr2[%d]에 저장할 값 입력 >>> ", i));
			arr[i] = sc.nextInt();
		}
	}

	// 배열 arr의 값들 중 가장 큰 값을 구하는 메소드
	public static int checkMaxinArray(int[] arr) {
		int max = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		return max;
	}

	// 배열 arr의 값들 중 가장 작은 값을 구하는 메소드
	public static int checkMininArray(int[] arr) {
		int min = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}

		return min;
	}
}
