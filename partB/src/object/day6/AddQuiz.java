package object.day6;

public class AddQuiz {
    private int data1;
    private int data2;
    private int userAnswer;
    
    // AddQuiz 객체 선언 시 data1과 data2에 랜덤 정수(11이상 99이하)를 저장
    // Math.random은 0.0이상 1.0미만의 실수를 랜덤으로 생성함.
    // 89를 곱하면 0.0이상 89.0미만이고, int형으로 캐스팅 후 11을 더하면 11이상 100미만이 됨
    public AddQuiz() {
        this.data1 = (int)(Math.random() * 89) + 11;
        this.data2 = (int)(Math.random() * 89) + 11;
    }


    public int getData1() {
        return data1;
    }

    public int getData2() {
        return data2;
    }

    public int getUserAnswer() {
        return userAnswer;
    }


    public void setData(int data1, int data2) {
        this.data1 = data1;
        this.data2 = data2;
    }

    public void setUserAnswer(int userAnswer) {
        this.userAnswer = userAnswer;
    }

    public boolean isRight() {
        return (this.userAnswer == (this.data1 + this.data2));
    }

}
