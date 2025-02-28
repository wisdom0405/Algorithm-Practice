package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 연결요소의개수구하기2 {
    static boolean[] visited; // 방문여부 배열
    static ArrayList<Integer>[] A; // 원본배열

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 1번 째 줄 읽음

        int N = Integer.parseInt(st.nextToken()); // 노드 개수
        int E = Integer.parseInt(st.nextToken()); // 엣지 개수

        visited = new boolean[N+1];
        A = new ArrayList[N+1];

        for(int i=1; i<N+1; i++){
            A[i] = new ArrayList<>(); // 각 노드별로 인접한 노드 연결해주기 위해 ArrayList 선언
        }

        for(int i=1; i<E+1; i++){
            // 인접노드 양방향 연결
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            A[node1].add(node2);
            A[node2].add(node1); // 양방향 연결
        }

        int count = 0; // DFS 횟수 초기화

        // DFS 순회 시작
        for(int i=1; i<N+1; i++){ // 노드1번 ~ N번 순회
            if(!visited[i]){
                // 방문하지 않은 노드라면 DFS탐색 시작
                count++; // DFS 횟수 추가
                DFS(i);
            }
        }
        System.out.println(count);
    }

    private static void DFS(int i) {
        if(visited[i]){
            // 이미 방문했던 노드라면 return
            return;
        }

        // i번 노드 탐색
        visited[i] = true; // 방문 check

        // i번 노드에 딸린 인접 노드 탐색
        for(int node : A[i]){
            if (!visited[node]){
                // 방문하지 않은 노드라면 다시 해당노드 DFS 탐색 시작
                DFS(node);
            }
        }
    }
}
