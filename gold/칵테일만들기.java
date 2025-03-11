package gold;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 칵테일만들기 {
    static int N;
    static ArrayList<ingredient>[] A;
    static long lcm; // 최소 공배수
    static boolean[] visited; // 방문배열
    static long[] ratio;

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 재료개수
        A = new ArrayList[N]; // 재료를 인접리스트로 생각한다.
        visited = new boolean[N]; // 방문배열 초기화
        ratio = new long[N]; // 재료 비율 값
        lcm = 1; // 최소공배수 초기화

        for(int i=0; i<N; i++){
            A[i] = new ArrayList<ingredient>();
        }

        for(int i=0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            long p = Long.parseLong(st.nextToken());
            long q = Long.parseLong(st.nextToken());

            // 인접노드 리스트 값 서로 넣어주기 (다른 재료와 비율)
            A[node1].add(new ingredient(node2, p, q));
            A[node2].add(new ingredient(node1, q, p));

            // 입력값 최소공배수 구하기
            lcm *= (p * q) / gcd(p,q);
        }

        ratio[0] = lcm;
        DFS(0);

        long ratioGCD = ratio[0];

        // 전체 DFS 탐색 후 배열 값들의 최대공약수로 나눠줘야됨
        // 배열 값들의 최대공약수 구하기
        for(int i=1; i<N; i++){
            ratioGCD = gcd(ratioGCD, ratio[i]);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<N; i++){
            bw.write(ratio[i]/ratioGCD + " ");
        }

        bw.flush();
        bw.close();

    }
    // 최대공약수 구하기
    private static long gcd(long A, long B){
        // 만약 B가 0으로 들어왔다면 최대공약수 구했으므로 return
        if(B == 0) return A;
        // 그게 아니라면 다시 나머지 연산
        return gcd(B, A%B);
    }

    // DFS 수행 (i번째 node DFS 수행)
    private static void DFS(int i){
        // 이미 방문했다면 return
//        if(visited[i]) return;

        // 방문하지 않았다면 방문체크 후 인접리스트 dfs 수행
        visited[i] = true;

        for(ingredient next : A[i]){
            // 인접리스트 순회하면서 방문하지 않은 노드 있다면
            int b = next.getB();
            if(!visited[b]){
                // 비율계산해서 값 update 후 DFS 재귀 호출
                // 나눗셈 먼저하면 0이 나올 수 있으므로 곱셈먼저 수행
                ratio[b] = ratio[i] * next.getQ() / next.getP();
                DFS(b);
            }
        }
    }
}

// ingredient 클래스 정의
class ingredient{
    int b; // 다른 재료 번호
    long p; // 비율 p
    long q; // 비율 q

    public ingredient(int b, long p, long q){
        super();
        this.b = b;
        this.p = p;
        this.q = q;
    }

    public int getB(){
        return b;
    }

    public long getP() {
        return p;
    }

    public long getQ(){
        return q;
    }
}
