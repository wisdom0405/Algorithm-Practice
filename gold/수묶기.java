package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 수묶기 {
    public static void main (String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 수열의 갯수

        // 우선순위 큐 선언, 내림차순 정렬
        PriorityQueue<Integer>pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i=0; i<N; i++){
            // pq에 수열 값 넣기
            pq.add(Integer.parseInt(br.readLine()));
        }

        int maxSum = 0; // 수열의 합 최댓값
        int num1 = 0;
        int num2 = 0;

        while (!pq.isEmpty()){
            // pq에 값이 하나만 있다면 그냥 출력
            if(pq.size() == 1){
                maxSum += pq.poll();
            }

            if (pq.size()>1){ // pq에 원소가 2개이상 들어있다면
                num1 = pq.remove(); // poll 해서 최대값 뽑음
                if(num1 > 1){
                    // 수가 1보다 크다면 수를 묶어서 더하는 것이 이득이다.
                    num2 = pq.remove();
                    maxSum += num1 * num2;
                } else if (num1 == 1) {
                    maxSum += num1;
                } else if(num1 < 1 && pq.size() <= 1){
                    // num1이 0 혹은 음수이고 pq에 원소가 1개밖에 남아있지않으면, 두 수를 곱해서 더하는게 이득
                    num2 = pq.remove();
                    maxSum += num1 * num2;
                }else{
                    // num1 < 1 && pq.size() >1 라면 음수끼리 곱해서 더하는게 이득
                    maxSum += num1;
                    num2 = pq.remove();
                    int num3 = pq.remove();
                    maxSum += num2 * num3;
                }
            }
        }

        System.out.println(maxSum);
    }
}
