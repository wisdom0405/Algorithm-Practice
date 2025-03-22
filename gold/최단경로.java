package gold;

import java.io.*;
import java.util.*;

public class 최단경로 {
    static int N,E,S;
    static boolean[] visited;
    static int[] distance;
    static ArrayList<int[]>[] A;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 1번째 줄 읽음
        N = Integer.parseInt(st.nextToken()); // 노드개수
        E = Integer.parseInt(st.nextToken()); // 에지개수
        visited = new boolean[N+1]; // 노드번호 1부터 시작
        distance = new int[N+1]; // 최단거리 배열
        int max = Integer.MAX_VALUE;
        Arrays.fill(distance, max); // distance 배열 값 모두 max값으로 채우기
        A = new ArrayList[N+1];

        // 인접노드 리스트 초기화
        for(int i=1; i<N+1; i++){
            A[i] = new ArrayList<>();
        }

        S = Integer.parseInt(br.readLine()); // 2번째 줄 : 시작노드
        distance[S] = 0; // 출발노드는 최단경로 0으로 update

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()); // 출발노드
            int end = Integer.parseInt(st.nextToken()); // 도착노드
            int weight = Integer.parseInt(st.nextToken()); // 가중치
            A[start].add(new int[] {end, weight});
        }
        // 출발노드부터 다익스트라 시작
        dijkstra(S);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=1; i<N+1; i++){
            if(distance[i] == max){
                bw.write("INF"+"\n");
            }else{
                bw.write(distance[i]+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
    private static void dijkstra(int start){
        // distance 배열 오름차순 정렬 우선순위 큐
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.comparingInt(a -> distance[a]));
        q.add(start);
        while (!q.isEmpty()){
            int now = q.poll(); // 거리 가장 짧은 노드
            visited[now] = true; // 현재 노드 방문처리
            for(int[] next : A[now]){ // 현재 노드의 인접리스트 순회
                int nextNode = next[0]; // 다음 노드
                int weight = next[1]; // 가중치
                if(!visited[nextNode]){
                    distance[nextNode] = Math.min(distance[nextNode], distance[now] + weight);
                    q.add(nextNode);
                }
            }
        }
    }
}
