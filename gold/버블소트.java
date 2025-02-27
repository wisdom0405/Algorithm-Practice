package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 버블소트 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 1번째 줄 읽음 : 배열의 크기

        int[] A = new int[N+1]; // 수는 배열의 1번방부터 채우므로 N+1 크기 배열 선언
        boolean changed = false; // swap 여부
        int temp = 0;
        int count = 0;

        // 원본배열 채우기 (1부터)
        for(int i=1; i<N+1; i++){
            A[i] = Integer.parseInt(br.readLine());
        }

        // 버블정렬
        for(int i=1; i<N+1; i++){ // N번째 loof 의미
            changed = false; // swap 여부 초기화
            for(int j=1; j<=N-i; j++){ // N번째 loof에서 인접요소 비교범위
                if(A[j] > A[j+1]){ // 오름차순 정렬
                    changed = true; // swap 됨 체크
                    temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp; // j, j+1번째 요소 swap
                }
            }
            count++;
            if(!changed){
                // loof 한번도는 동안 한번도 swap이 일어나지 않았다면 더이상 루프를 돌 필요가 없이 종료가능
                System.out.println(count);
                return;
            }
        }
    }
}
