package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 효율적인해킹2 {
    static boolean[] visited;
    static int N, M;
    static int[] answer;
    static ArrayList<Integer>[] A;

    public static void main(String[] argst)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new ArrayList[N+1];
        answer = new int[N+1];

        for(int i=1; i<=N; i++){
            A[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            A[S].add(E);
        }

        for(int i=1; i<=N; i++){
            visited = new boolean[N+1]; // 방문배열 초기화
            BFS(i);
        }

        int max = 0;
        for(int i=1; i<=N; i++){
            max = Math.max(max, answer[i]);
        }

        for (int i=1; i<=N; i++){
            System.out.print(i + " ");
        }

    }
    private static void BFS(int index){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        visited[index] = true;

        while (!queue.isEmpty()){
            int now = queue.poll();
            for(int i : A[now]){
                if (!visited[i]){
                    visited[i] = true;
                    answer[i]++;
                    queue.add(i);
                }
            }
        }

    }
}
