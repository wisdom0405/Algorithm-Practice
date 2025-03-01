package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 트리의지름 {
    static int N;
    static ArrayList<int[]>[] A;
    static boolean[] visited;
    static int maxDepth; // 최대 깊이
    static int maxDepthNode = 0; // 최대 깊이에 있는 노드번호

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 정점 개수 N
        A = new ArrayList[N+1]; // 정점 번호 1부터 시작
        visited = new boolean[N+1]; // 방문 여부

        for(int i=0; i<N+1; i++){
            A[i] = new ArrayList<>(); // 인접 노드 리스트 만들어주기
        }

        // 인접노드 정보 받기
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()); // 1번째 토큰 : 현재 노드 번호

            while (st.hasMoreTokens()){
                int node = Integer.parseInt(st.nextToken()); // 인접노드 번호

                if(node == -1) break;

                int distance = Integer.parseInt(st.nextToken()); // 인접노드와의 거리

                A[num].add(new int[] {node, distance}); // (노드번호, 거리) 저장
            }
        }

        // 1번 노드에서 시작해서 가장 먼 노드를 찾음
        DFS(1,0);

        // 가장 먼 노드에서 다시 DFS 수행하여 트리의 지름 구하기
        visited = new boolean[N+1]; // 방문배열 초기화
        maxDepth = 0; // 최대 깊이 초기화
        DFS(maxDepthNode, 0);

        System.out.println(maxDepth);
    }

    static void DFS(int node, int depth){
        if(visited[node]) return; // 이미 방문한 노드라면 return

        // 방문하지 않은 노드라면 방문체크 후 인접노드 순회
        visited[node] = true;
        if(depth > maxDepth){
            maxDepth = depth; // 최대거리 갱신
            maxDepthNode = node; // 가장 먼 노드 갱신
        }

        for(int[] next : A[node]){ // 인접노드 리스트 순회
            int nodeNum = next[0]; // 인접 노드번호
            int nodeDistance = next[1]; // 인접 노드와의 거리

            if(!visited[nodeNum]){
                // 인접노드 리스트 돌면서 방문하지 않은 노드번호가 있다면
                DFS(nodeNum, depth+nodeDistance);
            }
        }

        // for문 다 돌 때까지 더 이상 탐색할 다음 노드가 없다면 백트래킹
        visited[node] = false;
    }
}
