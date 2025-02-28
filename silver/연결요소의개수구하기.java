package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 연결요소의개수구하기 {
    static boolean[] visited; // 노드 방문여부 배열
    static ArrayList<Integer>[] A;// 원본배열

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 1번째 줄 읽음

        int N = Integer.parseInt(st.nextToken()); // 노드 개수
        int E = Integer.parseInt(st.nextToken()); // 엣지 개수 (노드 연결리스트 개수)

        visited = new boolean[N+1]; // 노드 1부터 시작하므로 N+1 크기 선언
        A = new ArrayList[N+1];// 노드 1부터 시작하므로 N+1 크기 배열선언

        // 노드 개수만큼 각 노드에 연결리스트 연결
        for(int i=1; i<N+1; i++){
            A[i] = new ArrayList<Integer>();
        }

        // 연결리스트 구현
        for(int i=1; i<E+1; i++){ // 엣지 갯수만큼 순회, 양방향 연결
            st = new StringTokenizer(br.readLine()); // 2 ~ E번째 줄 읽음
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            A[node1].add(node2); // 노드 양방향 연결
            A[node2].add(node1);
        }

        int DFScount = 0; // DFS 순회 횟수

        for(int i=1; i<N+1; i++){
            // 노드 1번 부터 순회
            if(!visited[i]){
                // 아직 방문하지 않은 노드가 있다면 DFS 실행
                DFScount++;
                DFS(i);
            }
        }
        System.out.println(DFScount);
    }

    private static void DFS(int i) {
        // i번 노드 DFS 탐색
        if(visited[i]){
            return; // 만약 i번 노드를 탐색해봤다면 탐색종료
        }

        // 아직 방문한적 없는 노드라면 방문체크 후 DFS 탐색수행
        visited[i] = true;
        for(int node : A[i]){
            // i번 노드에 딸려있는 인접 리스트 순회
            if(!visited[node]){
                // 딸려있는 인접 노드 방문하지 않았다면 DFS 수행
                DFS(node);
            }
        }
    }
}
