package gold;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 줄세우기 {
    static int N, M;
    static int[] count;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 사람 수 (노드 수)
        M = Integer.parseInt(st.nextToken()); // 키 비교횟수 (에지 수)

        count = new int[N + 1]; // 번호 1부터 시작
        A = new ArrayList[N + 1]; // 번호 1부터 시작
        visited = new boolean[N + 1]; // 방문배열

        // 인접노드 리스트 만들어주기
        for (int i = 1; i < N + 1; i++) {
            A[i] = new ArrayList<>();
        }

        // 인접노드 입력 받아서 연결해주기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            // node1 -> node2
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            // 순서연결 (인접노드)
            A[node1].add(node2);

            // 진입차수 count (node2를 가리키는 노드개수)
            count[node2] += 1;
        }

        for (int i=1; i<N+1; i++) {
            if (count[i] == 0 && !visited[i]) {
                // 진입차수가 0이고 방문한적 없는 노드라면 수행
                compareBFS(i);
                break;
            }
        }

    }
    private static void compareBFS(int i){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i); // 큐에 해당 노드 번호 넣는다.
        visited[i] = true; // 방문처리

        while (!queue.isEmpty()){
            int now = queue.poll(); // 현재노드
            System.out.print(now + " ");

            for(int next : A[now]){ // 현재노드의 인접리스트 순회
                count[next]--; // 현재노드의 인접노드들 진입차수 1빼줌
            }

            for(int j=1; j<N+1; j++){
                if(count[j]==0 && !visited[j]){
                    visited[j] = true; // 방문처리
                    queue.offer(j);
                }
            }
        }
    }
}
