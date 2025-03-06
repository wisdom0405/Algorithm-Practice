package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 수묶기3 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 우선순위 큐 선언
        // 양수이면 내림차정렬 pq
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
        // 음수이면 오름차정렬 pq
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();

        int ones = 0; // 1 개수 카운트 -> 1은 더하는게 이득
        int zeros = 0; // 0 개수 카운트 -> 음수 남은게 있으면 곱해서 더하는게 이득, 음수 없으면 그냥 더하는게 이득

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){ // 0은 음수와 곱해서 없애는 데 사용
                zeros ++;
            }else if (num == 1){ // 1은 더하는게 이득
                ones ++;
            }else if (num > 1){ // 2이상 양수저장
                maxPQ.add(num);
            }else{ // 음수저장
                minPQ.add(num);
            }
        }

        int sum = 0;

        // 양수는 최대한 곱해서 더하기
        while (maxPQ.size() > 1){
            int num1 = maxPQ.remove();
            int num2 = maxPQ.remove();
            sum += num1 * num2;
        }
        // 하나 남으면 그냥 더하기
        while (!maxPQ.isEmpty()){
            // 나머지는 더하는게 이득. pq에 남은 양수값
            sum += maxPQ.remove();
        }

        // 1은 더하는게 이득
        sum += ones;

        while (minPQ.size() > 1){
            // 음수들은 가장 작은 것부터 곱해서 더하면 이득
            int num1 = minPQ.remove();
            int num2 = minPQ.remove();
            sum += num1 * num2;
        }

        while (!minPQ.isEmpty()){
            // 남아있는 음수가 있다면 0이랑 곱해서 더하는게 이득
            int num1 = minPQ.remove();
            if(zeros > 0){
               zeros--;
            }else{
                sum += num1;
            }
        }

        System.out.println(sum);
    }
}
