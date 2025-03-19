package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 섬의개수 {
    static int W,H;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[][] A;
    static boolean[][] visited;
    static int count;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true){
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken()); // 너비
            H = Integer.parseInt(st.nextToken()); // 높이
            count = 0;

            if(W==0 && H==0) break; // 너비, 높이 둘다 0이면 함수 종료

            A = new int[H][W]; // 지도배열
            visited = new boolean[H][W]; // 방문여부

            // 지도 입력값 받기
            for(int i=0; i<H; i++){
                st = new StringTokenizer(br.readLine()); // 다음줄
                for(int j=0; j<W; j++){
                    A[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<H; i++){
                for(int j=0; j<W; j++){
                    if(A[i][j] == 1 && !visited[i][j]){
                        BFS(i,j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
    private static void BFS(int i, int j){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {i, j}); // 현재좌표 값 큐에 넣기
        visited[i][j] = true; // 방문체크

        while (!q.isEmpty()){ // 큐가 빌때까지
            int[] now = q.poll(); // 현재 좌표값 poll
            for(int k=0; k<8; k++){ // 상하좌우대각선 모두 좌표검사
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if(x>=0 && y>=0 && x<H && y<W){ // 다음 좌표값이 지도 범위내에 있고 방문하지 않았고 섬이라면
                    if(A[x][y] == 1 && !visited[x][y]){
                        q.add(new int[] {x,y});
                        visited[x][y] = true;
                    }
                }
            }
        }

    }
}
