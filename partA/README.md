# Java Part A
## 2023-12-28
기본 문법 

변수 및 자료형 

출력 메소드 

데이터 타입 캐스팅

Git
- git 초기화  
    ```sh
    $ git init
    ```
- git 사용자 이메일, 네임 설정  
    ```sh
    $ git config --global user.email {email}
    $ git config --global user.name {name}
    ```
## 2023-12-29
증감 연산자

아스키 코드

유니코드

반복문
- While 문

String 클래스
- String 메소드 
    - 인자 유무, 인자 개수, 리턴값 자료형에 따라 정리

Git
- git 원격 저장소 설정

## 2024-01-02
If-ElseIf-Else

3항 연산자

For문

While문
- 조건문과 변수를 사용해서 무한 반복하는 방법

Switch문

표준 입력
- java.util.Scanner 클래스를 이용해 터미널에서 값을 입력받는 방법

## 2024-01-03
변수의 영역
- 전역 변수, 지역 변수

For문
- 2중 For문
  - 구구단 출력하기

메소드
- 메소드 정의
  - 메소드를 만드는 이유
    - 자주 사용되는 기능을 main에서 분리 (구조화)
    - 같은 코드를 여러 번 작성하지 않고 재사용
- 메소드의 인자와 리턴값, 매개변수
  - 인자와 매개변수: 메소드의 실행에 필요한 입력 값
    - 인자(argument): 입력 값과 메소드 실행 부분을 연결시켜주는 변수
    - 매개변수: 선언된 변수
  - 리턴(return): 메소드를 실행한 결과 값
- static 메소드와 인스턴스 메소드
  - static: 클래스 이름으로 직접 호출. e.g. String.format(), Character.isUpperCase()
  - 인스턴스: 객체를 통해 호출. e.g. message.length(), sc.nextInt()

배열
- 배열과 For문
- int 배열
- char 배열
  - String과 char 배열
