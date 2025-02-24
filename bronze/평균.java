package bronze;

import java.util.Scanner;

public class 평균 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // N : 과목 개수
        int sum = 0; // 점수 합계
        int max = 0; // 점수 최대값

        for(int i = 0; i < N; i++){
           int score = sc.nextInt();
           sum += score;
           max = Math.max(score, max);
        }

        // (점수합계) / 최대값 * 100 / 과목개수
        // 100.0 : 평균값이 double형으로 나오게 하기 위해 100.0을 곱해준다.
        System.out.println(sum * 100.0 / max / N);
    }
}
