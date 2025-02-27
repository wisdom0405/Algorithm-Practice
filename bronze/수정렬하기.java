package bronze;

import java.io.*;
import java.util.StringTokenizer;

public class 수정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine()); // 1번째 줄 읽음

        int N = Integer.parseInt(st.nextToken()); // N : 숫자의 개수
        int[] A = new int[N]; // 크기 N의 배열 선언
        int swapCount = 0; // swap count

        // 원본배열에 값 넣기
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }

        // 버블정렬을 구현하는 영역
        for(int i=0; i<N-1; i++){
            swapCount = 0;
            for(int j=0; j<N-1-i; j++){
                if(A[j] > A[j + 1]){
                    swap(A, j, j+1);
                    swapCount++;
                }
            }
            if(swapCount ==0) break;
        }

        for (int i=0; i<N; i++){
            sb.append(A[i]).append("\n");
        }

        System.out.println(sb);
    }

    public static void swap(int[] A, int i, int j){
        int temp = 0;
        temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
