package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좋다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 1번째 줄 읽음

        int N = Integer.parseInt(st.nextToken()); // 수의 개수
        int [] arr = new int[N]; // 크기 N의 배열선언

        st = new StringTokenizer(br.readLine()); // 2번째 줄 읽음

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken()); // 차례대로 배열에 값 담기
        }

        Arrays.sort(arr); // 배열의 값 오름차순 정렬

        int count = 0;

        for(int i=0; i<N; i++){
            int start = 0; // 투포인터 start index
            int end = N-1; // 투포인터 end index : target 수의 바로 앞
            int target = arr[i];

            while (start < end){
                if(start == i){ // 현재숫자 제외
                    start++;
                    continue; // 현재 while문 건너뛰고 다음 while 루프 진행
                }

                if(end == i){ // 현재숫자 제외
                    end--;
                    continue;
                }

                if(arr[start] + arr[end] == target){
                    count++;
                    break; // while을 완전히 종료 후 for의 다음 루프 이동
                } else if (arr[start] + arr[end] < target) {
                    start++;
                } else{
                    // arr[start] + arr[end] > target
                    end--;
                }
            }
        }

        System.out.println(count);

    }
}
