package silver;

import java.io.*;
import java.util.*;

public class 유기농배추 {
    static int M; // 가로
    static int N; // 세로
    static int K; // 배추개수
    static int[][] A; // 배추밭
    static boolean[][] visited; // 방문여부
    static int count; // BFS 수행횟수
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수

        for(int i=0; i<T; i++){
            count = 0; // count 초기화
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()); // 가로
            N = Integer.parseInt(st.nextToken()); // 세로
            K = Integer.parseInt(st.nextToken()); // 배추 개수
            A = new int[M][N]; // 배추밭
            visited = new boolean[M][N]; // 방문여부 배열

            // 배추 위치 기록하기
            for(int j=0; j<K; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()); // 가로 좌표
                int y = Integer.parseInt(st.nextToken()); // 세로 좌표
                A[x][y] = 1;
            }

            for(int m=0; m<M; m++){
                for(int n=0; n<N; n++){
                    visited[m][n] = true; // 방문체크
                    if(A[m][n] == 1){ // 만약 배추가 있다면 BFS 탐색 수행
                        BFS(m,n);
                    }
                }
            }

            System.out.println(count);
        }
    }
    private static void BFS(int m, int n){
        count++;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {m,n});
        visited[m][n] = true;

        while (!queue.isEmpty()){
            int[] now = queue.poll(); // 현재좌표
            for(int i=0; i<4; i++){ // 상하좌우 탐색
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                if(x>=0 && y>=0 && x<M && y<N && !visited[x][y]){ // 상하좌우 값이 좌표를 벗어나지 않고 아직 방문하지 않았다면
                    visited[x][y] = true; // 방문체크 해주고
                    if(A[x][y] == 1){ // 탐색중인 인접 좌표에 배추가 있다면 큐에 좌표값 넣어줌
                        queue.add(new int[] {x,y});
                        A[x][y] = 0;
                    }
                }
            }
        }
    }
}
