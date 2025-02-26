package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스택 {

    static Stack<Integer> stack = new Stack<>(); // 스택초기화

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 1번째 줄 읽어들임

        int N = Integer.parseInt(st.nextToken()); // 명령어 개수

        for(int i=0; i<N; i++){
            stackProcess(stack, br.readLine());
        }
    }

    public static void stackProcess(Stack<Integer> stack, String command){
        // 명령어를 처리하는 스택함수 : stack과 String형의 명령어를 받음
        StringTokenizer st = new StringTokenizer(command);
        while (st.hasMoreTokens()){
            //token이 남은동안 실행
            switch (st.nextToken()){
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    System.out.println(stack.isEmpty() ? -1 : stack.pop());
                    break;

                case "size":
                    System.out.println(stack.size());
                    break;

                case "empty":
                    System.out.println(stack.isEmpty() ? 1 : 0);
                    break;

                case "top":
                    System.out.println(stack.isEmpty() ? -1 : stack.peek());
                    break;
            }
        }
    }
}
