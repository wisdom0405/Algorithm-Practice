package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 동전0 {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 동전 종류
        int K = Integer.parseInt(st.nextToken()); // 금액 총합 (target)

        Integer[] A = new Integer[N];

        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(br.readLine()); // 동전 가치 넣기
        }

        Arrays.sort(A, Collections.reverseOrder());

        int count = 0; // 동전개수
        for(int i=0; i<N; i++){
            if(K / A[i] >=1 ){
                // 해당 동전으로 나눌 수 있는 값이라면
                count += (K / A[i]); // 몫을 동전개수에 더함
                K = (K % A[i]);
            }
        }

        System.out.println(count);
    }
}
