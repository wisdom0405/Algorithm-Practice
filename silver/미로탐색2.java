package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색2 {
    static int N;
    static int M;
    static int[][] A;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우 좌표
    static int[] dy = {0, 0, -1, 1};

    public static void main (String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N+1][M+1]; // (1,1)부터 시작
        visited = new boolean[N+1][M+1];

        // 원본배열 값 입력받기 (미로)
        for(int i=1; i<N+1; i++){
            String[] line = br.readLine().split("");
            for(int j=1; j<M+1; j++){
                A[i][j] = Integer.parseInt(line[j-1]);
            }
        }

        BFS(1,1);
        System.out.println(A[N][M]);

    }

    static void BFS(int i, int j){
        Queue<int[]> queue = new LinkedList<>(); // 큐 선언
        queue.add(new int[] {i,j}); // 시작점 좌표 넣기
        visited[i][j] = true; // 방문체크

        while (!queue.isEmpty()){
            // 큐가 빌 때 까지 반복
            int[] now = queue.poll(); // 이번좌표 : queue에서 poll한 값

            for(int n=0; n<4; n++){
                int x = now[0] + dx[n]; // 이번좌표의 상하좌우 좌표 검사
                int y = now[1] + dy[n];

                // 상하좌우 좌표 유효성 검사 (범위 내에 있는지)
                if(x>0 && y>0 && x<=N && y<=M ){
                    // 막힌 길이 아니고 방문한 적 없는 좌표라면 queue에 add
                    if(A[x][y]!=0 && !visited[x][y]){
                        visited[x][y] = true;
                        queue.add(new int[] {x,y});

                        // 현재좌표값 + 1한 값으로 update
                        A[x][y] = A[now[0]][now[1]] + 1;
                    }
                }
            }
        }

    }

}
