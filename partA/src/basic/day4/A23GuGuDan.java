package basic.day4;

public class A23GuGuDan {
    public static void main(String[] args) {
        for(int i = 1; i <= 9; i++) { // 곱하는 수
            for(int j = 1; j <= 9; j++) { // 단 수
                System.out.print(String.format("%d x %d = %02d\t", j, i, i * j));
            }
            System.out.println();
        }
    }
}
