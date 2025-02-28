package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 신기한소수 {
    static int N;

    public static void main (String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // N 자리 수

        // 맨 앞자리는 반드시 소수여야 한다. (1은 소수가 아니므로 2,3,5,7 중 하나)
        // 그 다음 자리부터는 1,3,7,9 중 하나씩 추가
        DFS(2,1);
        DFS(3,1);
        DFS(5,1);
        DFS(7,1);
    }

    public static void DFS(int number, int jarisu){
        if(jarisu == N){
            if(isPrime(number)){
                System.out.println(number); // 자리수가 N을 만족 & 소수라면 출력
            }
        }

        // 그 외에는 계속 DFS 돈다.
        for(int i=0; i<10; i++){
            if(i%2 == 0){
                continue; // 짝수라면 탐색할 필요X
            }

            if(isPrime(number * 10 + i)){
                // 소수라면 다음 DFS 이동
                DFS(number * 10 + i, jarisu + 1);
            }
        }
    }

    public static boolean isPrime(int number){
        if(number < 2) return false; // 1은 소수아님
        if(number == 2 || number ==3) return true; // 2,3은 소수임

        // 그 외 숫자
        for(int i=2; i <= Math.sqrt(number); i++){ // √number까지 검사
            if(number % i == 0){
                return false;
            }
        }
        return true; // 루프를 끝까지 돌았다면 소수
    }
}
