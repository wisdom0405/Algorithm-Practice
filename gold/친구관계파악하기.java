package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 친구관계파악하기 {
    static int N;
    static int E;
    static ArrayList<Integer>[] friend;
    static boolean[] visited; // DFS 방문여부
    static boolean found = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 사람수 (노드 개수)
        E = Integer.parseInt(st.nextToken()); // 관계 개수 (엣지 개수)

        friend = new ArrayList[N]; // 사람 번호 0번부터 시작
        visited = new boolean[N];

        // 사람 수 만큼 인접 리스트 만들어줌
        for(int i=0; i<N; i++){
            friend[i] = new ArrayList<>();
        }

        // 관계 수(엣지) 만큼 for 순회하면서 관계 양방향 연결해주기
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int human1 = Integer.parseInt(st.nextToken());
            int human2 = Integer.parseInt(st.nextToken());

            friend[human1].add(human2);
            friend[human2].add(human1);
        }

        for(int i=0; i<N; i++){
            if(!found){ // 관계를 찾은게 아니라면 탐색 1부터 시작
                DFS(i,1);
            }
        }

        System.out.println(found ? "1" : "0");
    }

    public static void DFS(int i, int depth){
        if(depth ==5){
            found = true;
            return;
        }

        if(visited[i]) return; // 만약 이미 방문한 노드라면

        // 아직 방문하지 않았으면 DFS 탐색 시작
        visited[i] = true;
        for(int other : friend[i]){
            // 해당 노드(사람)의 친구관계 탐색
            if(!visited[other]){
                DFS(other, depth + 1);
            }
        }
        visited[i] = false;
    }
}
