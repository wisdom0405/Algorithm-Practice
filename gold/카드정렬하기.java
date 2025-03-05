package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 카드정렬하기 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 카드 묶음 갯수
        int sum = 0; // 카드묶음 비교 연산 누적합

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 오름차정렬 PQ

        // pq에 카드 묶음 넣기
        for(int i=0; i<N; i++){
            int card = Integer.parseInt(br.readLine());
            pq.add(card);
        }

        while (!pq.isEmpty()){
            // pq가 빌 때까지 수행
            int card1 = pq.poll();
            if(!pq.isEmpty()){
                int card2 = pq.poll();
                int newCard = card1 + card2;
                sum += newCard;
                if(pq.isEmpty()) break;
                pq.add(newCard);
            }
        }
        System.out.println(sum);
    }
}
