package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// BFS 버전
public class 트리의지름2 {
    static int N; // 정점 개수
    static boolean[] visited; // 방문여부
    static ArrayList<int[]>[] A;
    static int farestNode; // 가장 먼 거리에 있는 노드번호
    static int maxDistance; // 가장 먼 거리
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 트리 정점의 개수
        A = new ArrayList[N+1];
        visited = new boolean[N+1];

        // 인접노드 리스트 만들어주기
        for(int i=1; i<N+1; i++){
            A[i] = new ArrayList<>();
        }

        // 연결된 인접노드 리스트 값 넣어주기
        for(int i=1; i<N+1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken()); // 1번째 토큰 : 현재노드

            while (st.hasMoreTokens()){
                int nextNode = Integer.parseInt(st.nextToken());

                // -1 만나자마자 while 루프 종료
                if (nextNode == -1) break;

                int distance = Integer.parseInt(st.nextToken());
                A[node].add(new int[] {nextNode, distance});
            }
        }

        // 가장 먼 노드 찾기
        BFS(1,0); // 1번 노드에서 시작
        visited = new boolean[N+1]; // 방문배열 초기화
        maxDistance = 0; // 최대 거리 초기화
        BFS(farestNode, 0);
        System.out.println(maxDistance);

    }
    static void BFS(int node, int distance){
        visited[node] = true; // 방문체크

        // 거리 비교 후 새로운 거리값이 더 크다면 farestNode, maxDistance 업데이트
        if(distance > maxDistance){
            maxDistance = distance;
            farestNode = node;
        }
        queue.add(node);

        while (!queue.isEmpty()){
            int nextNode = queue.poll();

            // 인접노드 리스트 순회
            for(int[] next : A[nextNode]){
                int nodeNum = next[0];
                int nodeDistance = next[1];

                if(!visited[nodeNum]){
                    BFS(nodeNum, distance + nodeDistance);
                }
            }

            // for문 다 돌때까지 더 이상 탐색할 다음 노드가 없다면 백트래킹
            visited[node] = false;
        }

    }
}
