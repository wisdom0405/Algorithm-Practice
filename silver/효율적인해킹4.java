package silver;

import java.io.*;
import java.util.*;

public class 효율적인해킹4 {
    static int N; // 컴퓨터 수(노드 수)
    static int E; // 신뢰관계 (에지 수)
    static ArrayList<Integer>[] A;
    static int[] dependency; // 의존관계
    static boolean[] visited; // 방문여부
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 노드개수
        E = Integer.parseInt(st.nextToken()); // 에지개수
        A = new ArrayList[N+1]; // 노드번호 1부터 시작
        dependency = new int[N+1];

        // 각 노드별로 인접리스트 만들어주기
        for(int i=1; i<N+1; i++){
            A[i] = new ArrayList<>();
        }

        // 에지개수만큼 순회하면서 인접노드리스트 관계 값 넣어주기
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            A[node1].add(node2); // 단방향 관계
        }

        // 컴퓨터 모두 순회하면서 모두 BFS탐색 수행
        for(int i=1; i<N+1; i++){
            // i번째 노드부터 BFS 탐색
            Queue<Integer> queue = new LinkedList<>();
            visited = new boolean[N+1]; // 방문배열 초기화

            // 시작 노드값 큐에 넣기
            queue.offer(i);

            while (!queue.isEmpty()){
                // 큐가 빌 때까지 수행, 현재 노드 poll
                int now = queue.poll();
                for(int next : A[now]){
                    // 현재노드의 인접리스트 순회하면서 방문하지 않은 노드가 있다면 방문처리 후, dependency 추가 후 큐에 넣음
                    if(!visited[next]){
                        dependency[next]++;
                        queue.add(next);
                    }
                }
            }
        }

        // dependency 배열 값 최댓값 찾기
        int max = Integer.MIN_VALUE;
        for(int i=1; i<N+1; i++){
            max = Math.max(max, dependency[i]);
        }

        for(int i=1; i<N+1; i++){
            if(dependency[i] == max){
                System.out.print(i + " ");
            }
        }

    }
}
