package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수구하기2 {
    static int N;
    static int M;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());

        // N ~ M 사이 소수 구하기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for(int i=N; i<=M; i++){
            if(isPrime(i)){
                // 소수이면 stringbuilder에 출력
                sb.append(i+"\n");
            }
        }
        System.out.println(sb);
    }

    static boolean isPrime(int num){
        if (num < 2) return false; // 1은 소수아님
        if (num == 2 || num == 3) return true; // 2,3은 소수임

        for(int i=2; i<=Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
