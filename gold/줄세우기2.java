package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 줄세우기2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] indegree = new int[N+1];
        ArrayList<Integer>[] A = new ArrayList[N+1];

        for(int i=1; i<N+1; i++){
            A[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            A[node1].add(node2);
            indegree[node2]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<N+1; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while (!q.isEmpty()){
            int now = q.poll();
            System.out.print(now + " ");
            for(int next : A[now]){
                indegree[next]--; // 진입차수 1 감소
                if(indegree[next] == 0){
                    q.offer(next);
                }
            }
        }
    }
}
