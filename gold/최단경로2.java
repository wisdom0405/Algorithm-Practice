package gold;

import java.io.*;
import java.util.*;

public class 최단경로2 {
    static int N, E, S;
    static int[] distance;
    static ArrayList<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정점 개수
        E = Integer.parseInt(st.nextToken()); // 간선 개수

        distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE); // 최단 거리 초기화

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        S = Integer.parseInt(br.readLine()); // 시작 정점
        distance[S] = 0;

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, weight));
        }

        dijkstra(S);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= N; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                bw.write("INF\n");
            } else {
                bw.write(distance[i] + "\n");
            }
        }
        bw.flush();
        bw.close();
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            // 현재 노드의 최단 경로가 이미 더 짧다면 무시
            if (now.cost > distance[now.index]) continue;

            for (Node next : graph[now.index]) {
                int newDist = distance[now.index] + next.cost;
                if (newDist < distance[next.index]) {
                    distance[next.index] = newDist;
                    pq.add(new Node(next.index, newDist)); // 새로운 경로 추가
                }
            }
        }
    }
}
class Node implements Comparable<Node> {
    int index, cost;
    public Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }
    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost; // 비용(가중치) 오름차순 정렬
    }
}

