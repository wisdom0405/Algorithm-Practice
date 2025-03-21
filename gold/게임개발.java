package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 게임개발 {
    static int N;
    static ArrayList<Integer>[] A;
    static int[] result;
    static int[] indegree;
    static int[] time;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new ArrayList[N+1]; // 건물번호 1부터 시작
        result = new int[N+1]; // 최소시간 결과 배열
        indegree = new int[N+1]; // 진입차수 기록 배열
        time = new int[N+1]; // 건물짓는데 걸리는 시간 기록

        // 인접노드 리스트 만들어주기
        for(int i=1; i<N+1; i++){
            A[i] = new ArrayList<>();
        }

        StringTokenizer st;
        // 건물 정보 받기
        for(int i=1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            int takeTime = Integer.parseInt(st.nextToken()); // 첫번째 토큰은 건물짓는데 소요되는 시간
            time[i] = takeTime;

            while (st.hasMoreTokens()){
               int before = Integer.parseInt(st.nextToken()); // 2번째부터 다음토큰
               if(before != -1){
                   // 다음 토큰이 -1이 아니라면 기록해야 함
                   // before 노드 먼저 짓고 -> 현재 노드 건물 지을 수 있음
                   A[before].add(i);
                   indegree[i]++; // 현재노드 진입차수 1증가
               }
            }
        }

        Queue<Integer> q= new LinkedList<>();
        for(int i=1; i<N+1; i++){
            if(indegree[i] == 0){
                // 진입차수 0이라면 큐에 넣기
                q.offer(i);
                result[i] = time[i]; // 자기 자신 짓는 데 걸리는 시간 초기화
            }
        }

        while (!q.isEmpty()){
            int now = q.poll(); // 현재 노드

            for(int next : A[now]){ // 현재 노드의 인접리스트 순회
                indegree[next]--; // 진입차수 1감소
                result[next] = Math.max(result[next], result[now] + time[next]);

                if(indegree[next] == 0){
                    // 감소 후 진입차수가 0이 되었다면, 큐에 넣고 result에 현재노드의 소요시간 추가해준다.
                    q.offer(next);
                }
            }
        }

        for(int i=1; i<N+1; i++){
            System.out.println(result[i]);
        }

    }
}

