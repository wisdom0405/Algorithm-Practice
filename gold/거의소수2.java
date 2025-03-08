package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 거의소수2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long Min = Long.parseLong(st.nextToken()); // 시작 수
        long Max = Long.parseLong(st.nextToken()); // 종료 수

        // 입력 최댓값은 10^14 이므로 최댓값의 제곱근인 10^7까지 소수탐색
        long[] A = new long[10000001];

        for(int i=2; i<A.length; i++){
            A[i] = i;
        }

        // 에라토스테네스의 체 사용하여 소수구하기
        for(int i=2; i<=Math.sqrt(A.length); i++){ // 제곱근까지만 수행
            if(A[i] == 0) continue;
            for(int j = i+i; j<A.length; j=j+i){ // 배수 지우기
                A[j] = 0;
            }
        }

        int count = 0;
        for(int i=2; i<10000001; i++){
            if(A[i] != 0){ // 현재 선택한 수가 소수라면
                long temp = A[i]; // 현재 소수 -> 제곱하면서 거의소수 만들어감

                // N제곱하는 도중 값의 범위가 long형을 초과할 수 있기 때문에
                // N^k , B 비교가 아닌
                // N, B / N^(k-1) 비교로 수행한다.
                while ((double)A[i] <= (double)Max/(double)temp){
                    if((double)A[i] >= (double)Min/(double)temp){
                        count++;
                    }
                    temp *= A[i];
                }
            }
        }
        System.out.println(count);
    }
}
