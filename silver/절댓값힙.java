package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 절댓값힙 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 우선순위 큐 custom
        PriorityQueue<Integer> pq = new PriorityQueue<>( (A, B) -> {
            if(Math.abs(A) == Math.abs(B)) return A - B; // 절대값이 같다면 작은 값 먼저 반환(오름차 순)
            return Math.abs(A) - Math.abs(B); // 절댓값 오름차순 정렬
        }
        );

        int N = Integer.parseInt(br.readLine()); // 1번째 줄 읽음 (연산의 개수)
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine()); // 현재 숫자 (n번째 줄 읽어들임)
            if(num != 0){ // 0이 아니면
                pq.offer(num);
            }else{ // num = 0 일 때
                if(!pq.isEmpty()){ // 큐가 비어있지 않다면 값을 꺼내서 append
                    sb.append(pq.poll() + "\n");
                }else{
                    sb.append("0\n"); // 큐가 비어있다면 0 append
                }
            }
        }
        System.out.println(sb);
    }
}
