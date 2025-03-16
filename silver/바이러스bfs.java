package silver;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 바이러스bfs {
    static int N,E;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static int count;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // node
        E = Integer.parseInt(br.readLine()); // edge
        visited = new boolean[N+1];
        A = new ArrayList[N+1];

        for(int i=1; i<N+1; i++){
            A[i] = new ArrayList<>();
        }

        for(int i=0; i<E; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            A[node1].add(node2); // 양방향 그래프
            A[node2].add(node1);
        }

        BFS(1);
        System.out.println(count);
    }

    private static void BFS(int i){
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);

        while (!q.isEmpty()){
            int now = q.poll();
            visited[now] = true;
            for(int next : A[now]){
                if(!visited[next]){
                    count++;
                    visited[next] = true;
                    q.offer(next);
                }
            }

        }
    }
}
