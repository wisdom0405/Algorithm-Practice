package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 데이터 개수
        int[] A = new int[N]; // 크기N 원본배열 선언
        int[] S = new int[N]; // 크기N 합배열 선언

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken()); // 원본배열 값 넣기
        }

        Arrays.sort(A); // 배열 오름차순 정렬
        S[0] = A[0];
        for(int i=1; i<N; i++){
            S[i] = S[i-1] + A[i]; // 구간합 만들기
        }

        int sum = 0;
        for(int time : S){
            sum += time;
        }

        System.out.println(sum);
    }

}
