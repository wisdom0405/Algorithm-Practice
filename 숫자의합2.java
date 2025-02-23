import java.util.Scanner;

public class 숫자의합2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int numbers = sc.nextInt();
        sc.close();

        int sum = 0;
        while(numbers > 0){
            sum += numbers % 10; // 10으로 나눈 나머지 = 마지막 자리수
            numbers /= 10; // 10으로 나눈 몫 = 그 다음 numbers
        }

        System.out.println(sum);
    }
}
