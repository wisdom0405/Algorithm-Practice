package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS와BFS {
    static int N; // 노드개수
    static int E; // 에지개수
    static int start; // 시작노드
    static ArrayList<Integer>[] A; // 노드 배열
    static boolean[] DFSvisited; // DFS 방문여부 배열
    static boolean[] BFSvisited; // BFS 방문여부 배열
    static StringBuilder DFSsb = new StringBuilder(); // DFS 탐색문 출력 StringBuilder
    static StringBuilder BFSsb = new StringBuilder(); // BFS 탐색문 출력 StringBuilder
    static Queue<Integer> queue = new LinkedList<>();

    public static void main (String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 1번째 줄 읽음

        N = Integer.parseInt(st.nextToken()); // 노드개수
        E = Integer.parseInt(st.nextToken()); // 에지개수
        start = Integer.parseInt(st.nextToken()); // 시작 노드번호

        A = new ArrayList[N+1]; // 노드번호 1부터 시작 : N+1 크기
        DFSvisited = new boolean[N+1]; // 노드번호 1부터 시작 : N+1 크기
        BFSvisited = new boolean[N+1]; // 노드번호 1부터 시작 : N+1 크기

        // 원본배열에 인접리스트 연결해주기
        for(int i=1; i<N+1; i++){
            A[i] = new ArrayList<>();
        }

        // 원본배열 값, 인접노드 리스트 입력하기
        for(int i=1; i<E+1; i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            A[node1].add(node2);
            A[node2].add(node1);
        }

        // 인접노드 오름차순 정렬해줌
        for(int i=1; i<N+1; i++){
            Collections.sort(A[i]);
        }

        // DFS 탐색 출력
        DFS(start);

        // BFS 탐색 출력
        BFS(start);

        System.out.println(DFSsb);
        System.out.println(BFSsb);

    }

    private static void DFS(int start){ // 시작점 노드 입력받음
        if(DFSvisited[start]) return; // 이미 방문한 노드라면 return

        // 방문하지 않았다면
        DFSvisited[start] = true; // 방문처리해주고
        DFSsb.append(start + " ");

        for(int next : A[start]){
            if(!DFSvisited[next]){
                DFS(next);
            }
        }
    }

    private static void BFS(int start){ // 시작점 노드 입력받음

        queue.offer(start);
        BFSvisited[start] = true;

        while (!queue.isEmpty()){
            int next = queue.poll();
            BFSsb.append(next + " ");

            for(int i : A[next]){
                if(!BFSvisited[i]){
                    BFSvisited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}
