package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 소트인사이드2 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = br.readLine().split(""); // 한 글자씩 나누기
        Integer[] A = new Integer[numbers.length];

        // 원본배열 값 넣기
        for(int i=0; i<numbers.length; i++){
            A[i] = Integer.parseInt(numbers[i]);
        }

        // 내림차순 정렬
        Arrays.sort(A, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<A.length; i++){
            sb.append(A[i]);
        }

        System.out.println(sb);
    }
}
