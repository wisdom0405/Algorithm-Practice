package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 최대합 {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 1번째 줄 읽기
        List<Integer> arr = new ArrayList<>(); // 숫자 리스트
        int sum = 0; // 구간합
        int max = Integer.MIN_VALUE; // 최댓값

        while (st.hasMoreTokens()){ // 토큰이 남아있는 동안 실행
            arr.add(Integer.parseInt(st.nextToken())); // 숫자 리스트에 값 넣기
        }

        st = new StringTokenizer(br.readLine()); // 2번째 줄 읽기
        int window_size = Integer.parseInt(st.nextToken()); // 슬라이딩 윈도우 크기

        for(int i=0; i<arr.size(); i++){
            sum += arr.get(i); // 맨끝 값 더하기
            if(i >= window_size -1){ // 맨끝 값이 윈도우 크기를 벗어나기 시작하면
                max = Math.max(max, sum); // 최댓값 비교
                sum -= arr.get(i-(window_size-1)); // 윈도우 맨앞 값 빼주기
            }
        }
        System.out.println(max);
    }
}
