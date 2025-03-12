package silver;

import java.io.*;
import java.util.*;

public class 특정거리의도시찾기 {
    static int N; // 도시 개수
    static int E; // 에지 개수
    static int K; // 최단거리
    static int S; // 출발 도시번호
    static int[] depth; // 거리기록 배열
    static ArrayList<Integer>[] A;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 1번째 줄 읽음

        N = Integer.parseInt(st.nextToken()); // 도시 개수(노드)
        E = Integer.parseInt(st.nextToken()); // 도로개수(에지)
        K = Integer.parseInt(st.nextToken()); // 최단거리 (depth)
        S = Integer.parseInt(st.nextToken()); // 출발도시 번호(start node)

        depth = new int[N+1]; // 도시번호 1번부터 시작
        A = new ArrayList[N+1]; // 노드와 인접리스트 기록

        // depth 배열 -1로 초기화
        Arrays.fill(depth, -1);

        // 노드 별로 인접리스트 만들어주기
        for(int i=1; i<N+1; i++){
            A[i] = new ArrayList<>();
        }

        // 인접노드리스트 값 넣어주기 (에지 개수만큼)
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            A[node1].add(node2); // 단방향 간선
        }

        for(int i=1; i<N+1; i++){
            Collections.sort(A[i]);
        }

        // 시작노드 S부터 BFS 시작
        BFS(S);

        // BFS 모두 순회 후 거리가 K인 도시만 출력
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=1; i<N+1; i++){
            if(depth[i] == K){
                answer.add(i);
            }
        }

        // 정답리스트 오름차순 정렬
        Collections.sort(answer);
        if(!answer.isEmpty()){
            // answer 리스트가 비지 않았다면 도시번호 값 출력
            for(int i=0; i<answer.size(); i++){
                System.out.println(answer.get(i));
            }
        }else{
            System.out.println("-1");
        }

    }

    private static void BFS(int S){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(S); // 출발도시번호 넣기
        depth[S]++; // 출발 depth 0 시작

        while (!queue.isEmpty()){
            // queue가 빌 때까지 수행
            int now = queue.poll(); // 현재 노드

            for(int next : A[now]){ // 현재노드의 인접리스트 순회
                if(depth[next] == -1){
                    // 만약 한번도 방문하지 않은 노드라면 큐에 넣어준다.
                    queue.offer(next);
                    depth[next] = depth[now] + 1; // 이전 노드 depth에 1추가 (도로거리 무조건 1)
                }
            }
        }
    }
}
