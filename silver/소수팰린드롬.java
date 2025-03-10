package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 소수팰린드롬 {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // N보다 같거나 크면서 소수 & 팰린드롬

        // 소수 찾기 : 에라토스테네스의 체 이용
        int[] A = new int[1000001];

        // 각 index에 값 채우기
        for(int i=2; i<A.length; i++){
            A[i] = i;
        }

        // 최대값의 제곱근까지 소수찾기 (1은 소수아님)
        for(int i=2; i<Math.sqrt(A.length); i++){
            if(A[i] == 0) continue; // 소수가 아니면 건너 뜀
            for(int j=i+i; j<A.length; j+=i){ // 배수 지우기
                A[j] = 0;
            }
        }

        for(int i=N; i<A.length; i++){
            if(A[i] == 0) continue;

            // 소수라면 팰린드롬인지 검사
            if(isPalindrome(i)){
                System.out.println(A[i]);
                break;
            }
        }
    }

    private static boolean isPalindrome(int target) {
        // 소수라면 팰린드롬 검사 시작
        char[] P = String.valueOf(target).toCharArray();

        // start, end index
        int start = 0;
        int end = P.length - 1;

        while (start < end){
            // start, end가 가리키는 곳이 문자가 다르다면 false
            if (P[start] != P[end]) return false;

            // 같다면 point 이동
            start ++;
            end --;
        }
        // while문 다 돌 때까지 return 되지 않았다면 true
        return true;
    }


}
