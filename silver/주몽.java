package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 주몽 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()); // 1번째 줄 읽음
        int N = Integer.parseInt(st.nextToken()); // 재료의 개수

        st = new StringTokenizer(br.readLine()); // 2번째 줄 읽음
        int M = Integer.parseInt(st.nextToken()); // 옷이 완성되는 번호의 합

        st = new StringTokenizer(br.readLine()); // 3번째 줄 읽음
        int[] arr = new int[N]; // 크기N의 배열선언

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken()); // 배열에 재료 고유번호 담음
        }

        Arrays.sort(arr); // 배열 오름차순 정렬
        int start = 0; // 첫번째 index
        int end = N-1; // 마지막 index
        int count = 0; // 카운트 값

        while (start < end){
            if(arr[start] + arr[end] < M){
                start++;
            } else if (arr[start] + arr[end] == M) {
                count++;
                start++;
                end--;
            } else{
                // arr[start] + arr[end] > M
                end--;
            }
        }

        System.out.println(count);
    }
}
