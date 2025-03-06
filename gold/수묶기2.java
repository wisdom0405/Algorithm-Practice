package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 수묶기2 {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 우선순위 큐 선언 (양수 : 내림차순)
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
        // 0, 음수 : 오름차 순
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num > 0){
                maxPQ.add(num);
            }else{
                minPQ.add(num);
            }
        }

        int sum = 0;

        while(!maxPQ.isEmpty()){
            // 양수는 무조건 곱하는게 이득
            if(maxPQ.size() > 1){
                // pq에 원소가 2개이상 들어있다면 두 수를 곱해서 수열의값에 더해준다.
                int num1 = maxPQ.remove();
                if (num1 == 1){
                    // 숫자가 1이라면 더하는게 이득
                    sum += num1;
                }else{
                    int num2 = maxPQ.remove();
                    sum += num1 * num2;
                }
            }else{
                // pq.size() <= 1 (1개 이하라면 그냥 더한다.)
                sum += maxPQ.remove();
            }
        }

        while (!minPQ.isEmpty()){
            // 음수는 제일 작은 값들끼리 곱해서 더하는게 이득
            if(minPQ.size() > 1){
                int num1 = minPQ.remove();
                int num2 = minPQ.remove();
                sum += num1 * num2;
            }else{
                sum += minPQ.remove();
            }
        }

        System.out.println(sum);
    }
}
