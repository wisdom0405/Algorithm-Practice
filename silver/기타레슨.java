package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기타레슨 {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 강의 개수
        int M = Integer.parseInt(st.nextToken()); // 블루레이 개수

        int[] A = new int[N];

        int sum = 0; // 강의시간 총합
        int max = 0; // 강의 최대길이 시간
        int minSize = 0; // 블루레이 최소시간

        st = new StringTokenizer(br.readLine());

        // 강의시간 입력받기, 강의길이 총합, 최대길이시간 구하기
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken()); // 강의시간 입력받기
            sum += A[i];
            max = Math.max(max, A[i]);
        }

        // 이분탐색 index
        int start = max;
        int end = sum;
        int result = 0;

        // 강의 최대길이 ~ 총합 사이에서 이분탐색
        while (start <= end){
            int mid = (start + end) / 2; // 현재 블루레이 크기 후보
            int count = 1; // 필요한 블루레이 개수 (최소 1개 필요)
            int lectureSum = 0; // 현재 블루레이에 저장된 강의 길이 합

            for(int lecture : A){
                // 하나의 블루레이에 들어갈 강의시간 합계가 블루레이 하나의 크기보다 커지면
                if(lectureSum + lecture > mid){
                    count++; // 블루레이 갯수 + 1
                    lectureSum = 0; // 강의시간 합계 초기화
                }
                // 그 외에는 강의시간 총합 + 현재강의시간
                lectureSum += lecture;
            }

            // for문 다 돌고나왔을 때 필요한 블루레이 개수 비교
            if(count <= M){
                // 블루레이 개수보다 count가 작으면 블루레이 크기 줄여도 됨
                result = mid;
                end = mid - 1;
            }else{
                // count > M 이면 블루레이 크기를 늘려야 함
                start = mid + 1;
            }
        }

        System.out.println(result);
    }
}
