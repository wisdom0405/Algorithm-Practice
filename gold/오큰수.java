package gold;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class 오큰수 {
    public static void main (String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 1번째 줄 읽음 : 수열 크기
        int N = Integer.parseInt(st.nextToken()); // 수열의 크기 N

        int[] A = new int[N]; // 원본배열
        int[] result = new int[N]; // 오큰수 배열

        st = new StringTokenizer(br.readLine()); // 2번째 줄 일기(수열)
        // 원본배열 값 담기
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        // 오큰수 찾기
        for(int i=0; i<N; i++){
            while (!stack.isEmpty() && A[stack.peek()] < A[i]){
                // 스택이 비어있지 않고 A[top] < A[i] 일 동안 (오큰수가 있는 경우)
                int top = stack.pop();
                result[top] = A[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()){
            // stack이 빌때 까지 오큰수 못찾은 오큰수 배열 인덱스에 -1 채워주기
            result[stack.pop()] = -1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<N; i++){
            bw.write(result[i]+" "); // 오큰 수 배열 공백기준으로 작성
        }

        bw.write("\n");
        bw.flush();

    }
}
