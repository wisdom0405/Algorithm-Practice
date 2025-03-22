package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소비용구하기 {
    static int N,E;
    static int depart, destination;
    static ArrayList<int[]>[] A;
    static boolean[] visited;
    static int[] cost;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 도시개수(노드)
        E = Integer.parseInt(br.readLine()); // 버스개수(에지)
        A = new ArrayList[N+1]; // 버스번호 1부터 시작
        visited = new boolean[N+1]; // 방문배열
        cost = new int[N+1]; // 최소비용 배열

        // 인접노드리스트 초기화
        for(int i=1; i<N+1; i++){
            A[i] = new ArrayList<>();
        }

        int start, end, busCost;
        StringTokenizer st;
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken()); // 출발도시번호
            end = Integer.parseInt(st.nextToken()); // 도착도시번호
            busCost = Integer.parseInt(st.nextToken()); // 버스비용

            A[start].add(new int[] {end, busCost});
        }

        int max = Integer.MAX_VALUE;
        Arrays.fill(cost, max); // max 값으로 모두 채우기

        st = new StringTokenizer(br.readLine());
        depart = Integer.parseInt(st.nextToken()); // 출발도시번호
        destination = Integer.parseInt(st.nextToken()); // 도착도시번호
        cost[depart] = 0; // 출발도시번호만 거리0으로 초기화

        // 다익스트라 수행
        dijkstra(depart);
        System.out.println(cost[destination]);
    }
    private static void dijkstra (int depart){
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> cost[a] - cost[b]);
        q.offer(depart);

        int now, nextNode, busCost;
        while (!q.isEmpty()){
            now = q.poll(); // 현재노드
            visited[now] = true;
            for(int[] next : A[now]){
                nextNode = next[0];
                busCost = next[1];
                if(!visited[nextNode]){
                    // 아직방문하지 않은 노드라면 최솟값 비교 후 update, 큐에 넣어준다.
                    cost[nextNode] = Math.min(cost[nextNode], cost[now] + busCost);
                    q.offer(nextNode);
                }
            }
        }
    }
}
