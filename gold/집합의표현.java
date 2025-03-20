package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 집합의표현 {
    static int N,Q;
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 원소개수
        Q = Integer.parseInt(st.nextToken()); // 질의개수
        A = new int[N+1]; // 1 ~ N까지의 원소

        for(int i=1; i<=N; i++){
            A[i] = i; // 자기자신이 대표노드 (초기화)
        }

        // 질의시작
        for(int i=0; i<Q; i++){
            st = new StringTokenizer(br.readLine()); // 다음줄 읽음
            int unionFind = Integer.parseInt(st.nextToken()); // union? find?
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int min = Math.min(a,b);
            int max = Math.max(a,b);

            if(unionFind == 0){ // union 연산
                union(min,max);
            }else{ // find 연산
                System.out.println(isUnion(min,max)? "YES" : "NO");
            }
        }
    }
    // 합집합 만들기
    private static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b){
            // a의 대표노드와 b의 대표노드가 다르다면 대표노드 연결해주기
            A[b] = a;
        }
    }
    // 대표노드 찾기
    private static int find(int a){
        // 자기자신이 대표노드라면 index 리턴
        if(A[a] == a ) return a;

        // 자기자신이 대표노드가 아니라면 대표노드 찾아가기(재귀함수 호출)
        int parent = A[a];
        return A[a] = find(parent); // 경로압축 : 대표노드 update
    }
    // 같은 집합에 속해있는지 확인
    private static boolean isUnion(int a, int b){
        return find(a) == find(b);
    }

}
