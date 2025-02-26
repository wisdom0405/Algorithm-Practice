package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 카드2 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 1번째 줄 읽음 카드개수 N

        int N = Integer.parseInt(st.nextToken()); // 카드개수
        Queue<Integer> queue = new LinkedList<>();
        // 카드 순서대로 큐에 넣기
        for(int i=1; i<=N; i++){
            queue.offer(i); // 순서대로 값 넣기
        }

        // 카드놀이 시작 (카드 1장 남을 때까지)
        while (queue.size() > 1){
            // 카드가 2장이상 남아있다면
            int first = queue.poll(); // 맨 위의 값 제거
            int second = queue.poll(); // 2번째 값 뽑는다.
            queue.offer(second); // 2번째 값 맨 뒤로 넣는다.
        }

        System.out.println(queue.poll());

    }
}
