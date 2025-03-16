package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 바이러스 {
    static int N,E;
    static ArrayList<Integer>[] A;
    static boolean[] visitied;
    static int count;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 컴퓨터 개수 (노드)
        E = Integer.parseInt(br.readLine()); // 연결개수 (에지)
        A = new ArrayList[N+1]; // 1번부터 시작
        visitied = new boolean[N+1]; // 방문배열

        for(int i=1; i<N+1; i++){
            A[i] = new ArrayList<>(); // 1번부터 시작
        }

        for(int i=0; i<E; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            A[node1].add(node2);
            A[node2].add(node1);
        }
        count = 0;
        DFS(1);
        System.out.println(count);
    }

    private static void DFS(int i){
        if(visitied[i]) return; // 이미 방문했다면 함수 종료

        visitied[i] = true; // 방문체크
        for(int now : A[i]){ // i번째 노드의 인접노드리스트 순회
            if(!visitied[now]){
                count++; // 방문노드 횟수 증가
                DFS(now);
            }
        }

    }
}
