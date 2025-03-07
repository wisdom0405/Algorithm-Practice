package silver;

import java.io.*;
import java.util.StringTokenizer;

public class 소수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N ~ M 사이의 소수 구하기
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int range = M-N+1;

        int[] A = new int[range];

        // 1차원 배열 N ~ M까지 돌면서 수 채우기
        for(int i=0; i<range; i++){
            A[i] = N+i;
        }

        // 배열 순회하면서 특정한 수 선택, 선택한 수의 배수 지우기
        for(int i=0; i<range; i++){
            int target = A[i];
            if(target == 1){
                A[i] = 0; // 1은 소수가 아님
                continue; // 건너뛴다.
            }
            for(int j=i+1; j<range; j++){
                if(A[j] == 0){
                    continue;
                }
                if(target % j == 0){
                    A[i] = 0;
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=0; i<range; i++){
            if(A[i] != 0){
                bw.write(A[i] + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
