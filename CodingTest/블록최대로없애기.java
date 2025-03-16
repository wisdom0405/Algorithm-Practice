package CodingTest;

import java.util.*;
import java.util.stream.Stream;

public class 블록최대로없애기 {
    static char[][] A;
    static int N;
    public static void main(String[] args){
//        String[] board = {"DDCCC","DBBBC", "DBABC","DBBBC","DDCCC"};
        String[] board = {"ABB","AAC", "ACC"};
//        int N = board.length;
//        char[][] A = new char[N][N]; // NxN 문자 행렬
//        for(int i=0; i<N; i++){
//            A[i] = board[i].toCharArray();
//        }
//        for(int i=0; i<N; i++){
//            for(int j=0; j<N; j++){
//                System.out.print(A[i][j]+" ");
//            }
//            System.out.print("\n");
//        }
        int answer = solution(board);
        System.out.println(answer);
    }

    private static int solution(String[] board){
        N = board.length;
        A = new char[N][N]; // NxN 문자 행렬

        // 1차원 배열 -> NxN 행렬로 변환
        for(int i=0; i<N; i++){
            A[i] = board[i].toCharArray();
        }

        // 경계 몇번 변했는지 count
        int[][] boarderChange = new int[2][N];

        // 세로 줄
        for(int i=0; i<N; i++){
            int count = 1;
            char now = A[0][i];
            for(int j=1; j<N; j++){
                if(now != A[j][i]){
                    count++; // 만약 경계가 바뀌었다면 count up
                    now = A[j][i];
                }
            }
            boarderChange[0][i] = count; // n번째 세로줄 경계 몇 번 바뀌었는지 기록
        }

        // 가로 줄
        for(int i=0; i<N; i++){
            int count = 1;
            char now = A[i][0];
            for(int j=1; j<N; j++){
                if(now != A[i][j]) {
                    count++; // 만약 경계가 바뀌었다면 count up
                    now = A[i][j];
                }
            }
            boarderChange[1][i] = count; // n번째 가로줄 경계 몇 번 바뀌었는지 기록
        }

        // 경계가 가장많이 변한 횟수
        int changeMax = Arrays.stream(boarderChange)
                .flatMapToInt(Arrays::stream)
                .max()
                .getAsInt();

        ArrayList<int[]> candidate = new ArrayList<>(); // 경계가 가장 많이 변한 줄(후보리스트)

        // 최댓값과 같은 좌표값 후보리스트에 저장
        for(int i=0; i<2; i++){
            for(int j=0; j<N; j++){
                if(boarderChange[i][j] == changeMax){
                    candidate.add(new int[] {i,j});
                }
            }
        }

        int maxEmpty = 0;
        for(int[] c : candidate){
            // c[0] : 세로(0), 가로(1)
            // c[1] : n번째 줄
            int n = c[1];
            int count = 0;

            if(c[0] == 0){
                
                for(int i=0; i<N; i++){
                    count += BFS(i,n); // (i,n)좌표 BFS
                }
                maxEmpty = Math.max(maxEmpty, count);
            }else{
                for(int i=0; i<N; i++){
                    count += BFS(n,i);
                }
                maxEmpty = Math.max(maxEmpty, count);
            }
        }



//        for(int i=0; i<2; i++){
//            for(int j=0; j<N; j++){
//                System.out.print(boarderChange[i][j] + " ");
//            }
//            System.out.print("\n");
//        }
        return maxEmpty;
    }

    // 세로 n번째 줄 BFS
    public static int BFS(int x, int y){
        boolean[][] visited = new boolean[N][N];
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        int count = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x,y});
        char nowChar = A[x][y];
        visited[x][y] = true;

        while (!queue.isEmpty()){
            int[] now = queue.poll();
            for(int i=0; i<4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx>=0 && ny>=0 && nx<N && ny<N){ // 좌표가 범위 안에 있다면
                    if(!visited[nx][ny] && A[nx][ny] == nowChar){
                        visited[nx][ny] = true; // 방문처리
                        count++;
                        queue.offer(new int[] {nx,ny});
                    }
                }
            }

        }
        return count;
    }


}
