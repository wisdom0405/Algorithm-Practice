package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 괄호 {
    static char[] chars;
    static Stack<Character> stack;
    static String isVPS;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 1번째 줄 읽음

        int N = Integer.parseInt(st.nextToken()); // 질의 개수

        for(int i=0; i<N; i++){
            chars = br.readLine().toCharArray(); // n번째 괄호문자열 읽어서 char 문자열로 변환
            stack = new Stack<>(); // char형 스택 초기화
            isVPS(chars, stack);
            System.out.println(isVPS);
        }
    }

    public static void isVPS(char[] chars, Stack<Character> stack){
        // 입력으로 받은 문자열 순회
        for(char ch : chars){
            if(ch == '('){
                stack.push(ch); // 열린괄호면 무조건 push
            } else{ // ch == ')'
                if(!stack.isEmpty()){
                    stack.pop(); // 닫힌괄호이고 스택이 비어있지않다면 짝이 맞는 열린괄호가 남아있음으로 pop
                }else{
                    // ch == ')' && stack.isEmpty()
                    isVPS = "NO";
                    return; // 함수 실행종료
                }
            }
        }
        // 문자열 순회 끝났을 때 스택이 비어있다면 올바른 문자열
        if(stack.isEmpty()){
            isVPS = "YES";
        }else{
            isVPS = "NO";
        }

    }
}
