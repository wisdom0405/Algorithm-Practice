package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 여행가자 {
    static int N,M;
    static int[][] A; // 지도배열
    static int[] parent; // 대표노드 배열
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine()); // 도시개수
        M = Integer.parseInt(br.readLine()); // 계획하는 도시개수

        A = new int[N+1][N+1]; // 도시번호 1부터 시작함
        parent = new int[N+1]; // 대표노드 저장배열

        for(int i=1; i<N+1; i++){
            parent[i] = i; // 대표노드 : 자기자신으로 초기화
        }

        // 지도배열 입력 받기
        for(int i=1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<N+1; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // union 연산
        for(int i=1; i<N+1; i++){
            for(int j=1; j<N+1; j++){
                if(A[i][j] == 1){
                    union(i, j);
                }
            }
        }

        // 여행계획 순서대로 도시번호 저장
        int[] plan = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            plan[i] = Integer.parseInt(st.nextToken());
        }

        int first = find(plan[0]); // 첫번째 도시의 대표 노드

        for(int i=1; i<M; i++){
            if(first != find(plan[i])){
                // 첫번째 여행도시의 대표노드와 현재 여행도시의 대표노드가 같지 않다면
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");

    }
    private static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b){ // a의 대표노드의 b의 대표노드가 다르다면
            parent[b] = a; // b의 대표노드에 a의 대표노드 값 넣어주기
        }
    }
    private static int find(int a){
        if(a == parent[a]) return a; // 내가 대표노드라면 index값 return
        return parent[a] = find(parent[a]); // 그 외에는 내 대표노드의 대표노드 찾아서 넣어주기
    }
}
