import java.util.Scanner;

public class 숫자의합 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 1번째 입력 : 숫자개수 N

        // 입력값을 String형 변수 sNum에 저장한 후 char[]형 변수로 변환하기
        // sc.next() : 입력으로부터 한줄 전체 읽음
        String sNum = sc.next();  // 2번째 입력 : N개의 숫자가 공백없이 주어짐
        char[] cNum = sNum.toCharArray();

        int sum = 0;
        for(int i=0; i < cNum.length; i++){
            sum += cNum[i] - '0'; // cNum[i]를 정수형으로 변환하면서 sum에 더하여 누적하기
        }

        System.out.println(sum);
    }
}
