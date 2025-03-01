package gold;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 신기한소수2 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        DFS(2,1, N);
        DFS(3,1, N);
        DFS(5,1, N);
        DFS(7,1, N);
    }
    // DFS
    public static void DFS(int num, int jarisu, int N){
        if(jarisu == N && isPrime(num)){
            System.out.println(num); // N자리수를 만족하고 소수라면 해당 값 출력
        }

        int[] nextPrime = {1,3,7,9}; // 그 다음에 붙을 소수 후보들

        for(int next : nextPrime){
            if(isPrime(num * 10 + next)){
                DFS(num * 10 + next, jarisu + 1, N);
            }
        }
    }

    // 소수인지 판별하는 함수
    public static boolean isPrime(int num){
        // 1은 소수가 아니다.
        if(num < 2) return false;

        // 그 외 숫자 : 2 ~ sqrt(num)까지 나눠떨어지는 수가 있다면 false
        for(int i=2; i<Math.sqrt(num); i++){
            if(num % i == 0) return false;
        }
        // for문을 다 순회하는데 성공했다면 소수이다.
        return true;
    }
}
