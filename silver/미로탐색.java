package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색 {
    static int N;
    static int M;
    static int[][] A;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};

    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N+1][M+1]; // (1,1) 부터 시작
        visited = new boolean[N+1][M+1]; // 방문여부

        // 원본 배열 값 넣기
        for(int i=1; i<N+1; i++){
            String[] line = br.readLine().split(""); // 한 글자씩 나눠서 배열로 저장
            for(int j=1; j<M+1; j++){
                A[i][j] = Integer.parseInt(line[j-1]);
            }
        }

        BFS(1,1);
        System.out.println(A[N][M]);
    }

    static void BFS(int i, int j){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});
        visited[i][j] = true; // 방문 체크

        while (!queue.isEmpty()){
            int[] next = queue.poll(); // 다음탐색 좌표 (x,y)
            for(int n=0; n<4; n++){
                int x = next[0] + dx[n]; // 다음좌표 상하좌우 탐색
                int y = next[1] + dy[n];

                if(x >=1 && y >=1 && x <= N && y <= M){ // 상하좌우 좌표가 범위를 벗어나지 않음
                    // x,y 좌표가 막힌길이 아니고 방문한적 없다면
                    if(A[x][y]!=0 && !visited[x][y]){
                        visited[x][y] = true; // 방문체크
                        queue.offer(new int[] {x, y}); // 해당좌표 큐에 넣기
                        A[x][y] = A[next[0]][next[1]] + 1;
                    }
                }

            }
        }

    }
}
