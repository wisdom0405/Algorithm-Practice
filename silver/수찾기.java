package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수찾기 {
    static int N; // 원본배열 갯수
    static int M; // 타겟배열 갯수
    static int[] A; // 원본 배열
    static int[] T; // target 값이 들어있는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 1번째 줄 읽음
        A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine()); // 2번째 줄 읽음 : 원본배열

        // 원본배열 값 넣기
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 원본배열 오름차순 정렬
        Arrays.sort(A);

        M = Integer.parseInt(br.readLine()); // 3번째 줄 읽음. 타겟 배열 갯수
        T = new int[M];

        st = new StringTokenizer(br.readLine()); // 4번째 줄 읽음. 타겟 값들
        // 타겟 배열 값 넣음
        for (int i=0; i<M; i++){
            T[i] = Integer.parseInt(st.nextToken());
        }

        // 타겟 갯수 만큼 질의시작
        for(int i=0; i<M; i++){
            boolean found = binarySearch(A, 0,N-1, T[i]); // search할 원본배열, 끝 index, 찾을 값 target
            System.out.println(found ? "1" : "0");
        }

    }
    static boolean binarySearch(int[] A,int start, int end, int target){
        if(start > end) return false; // 탐색 종료 조건 (start가 end 초과하면 값 없음)

        int median = (start + end) / 2; // 중앙 index

        if(A[median] == target) return true;
        else if(A[median] > target){
            // 중앙값이 target보다 크다면 왼쪽 data set 선택
            return binarySearch(A, start,median-1, target);
        }
        else{
            // A[median] < target
            // 중앙값이 target보다 작다면 오른쪽 data set 선택
            return binarySearch(A, median+1, end, target);
        }
    }
}
