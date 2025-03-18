package CodingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 블록최대로없애기2 {
    static char[][] A;
    static int N;

    public static void main(String[] args){
        String[] board = {"ABB","AAC", "ACC"};
        int answer = solution(board);
        System.out.println(answer);
    }

    private static int solution(String[] board){
        N = board.length;
        A = new char[N][N];

        // 1차원 배열 -> NxN 행렬로 변환
        for(int i = 0; i < N; i++){
            A[i] = board[i].toCharArray();
        }

        int[][] boarderChange = new int[2][N];

        // 세로 줄 경계 변화 횟수 세기
        for(int i = 0; i < N; i++){
            int count = 1;
            char now = A[0][i];
            for(int j = 1; j < N; j++){
                if(now != A[j][i]){
                    count++;
                    now = A[j][i];
                }
            }
            boarderChange[0][i] = count;
        }

        // 가로 줄 경계 변화 횟수 세기
        for(int i = 0; i < N; i++){
            int count = 1;
            char now = A[i][0];
            for(int j = 1; j < N; j++){
                if(now != A[i][j]) {
                    count++;
                    now = A[i][j];
                }
            }
            boarderChange[1][i] = count;
        }

        // 경계가 가장 많이 변한 횟수
        int changeMax = Arrays.stream(boarderChange)
                .flatMapToInt(Arrays::stream)
                .max()
                .getAsInt();

        ArrayList<int[]> candidate = new ArrayList<>(); // 경계가 가장 많이 변한 줄 후보리스트

        for(int i = 0; i < 2; i++){
            for(int j = 0; j < N; j++){
                if(boarderChange[i][j] == changeMax){
                    candidate.add(new int[] {i,j});
                }
            }
        }

        int maxEmpty = 0;
        for(int[] c : candidate){
            int n = c[1];
            if(c[0] == 0){ // 세로 줄
                char[][] temp = new char[N][N];
                for (int i = 0; i < N; i++) {
                    temp[i] = Arrays.copyOf(A[i], N);
                }
                // 해당 세로줄 제거
                for (int i = 0; i < N; i++) {
                    temp[i][n] = '.';
                }
                maxEmpty = Math.max(maxEmpty, countEmpty(temp));
            } else { // 가로 줄
                char[][] temp = new char[N][N];
                for (int i = 0; i < N; i++) {
                    temp[i] = Arrays.copyOf(A[i], N);
                }
                // 해당 가로줄 제거
                for (int i = 0; i < N; i++) {
                    temp[n][i] = '.';
                }
                maxEmpty = Math.max(maxEmpty, countEmpty(temp));
            }
        }

        return maxEmpty;
    }

    // 빈칸의 개수를 세는 함수 (빈칸을 채우는 과정에서 BFS)
    public static int countEmpty(char[][] tempBoard){
        int count = 0;
        boolean[][] visited = new boolean[N][N];
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(tempBoard[i][j] == '.' && !visited[i][j]){
                    queue.add(new int[] {i, j});
                    visited[i][j] = true;
                    count++;

                    // BFS로 연결된 빈칸 탐색
                    while(!queue.isEmpty()){
                        int[] now = queue.poll();
                        for(int k = 0; k < 4; k++){
                            int nx = now[0] + dx[k];
                            int ny = now[1] + dy[k];

                            if(nx >= 0 && ny >= 0 && nx < N && ny < N){
                                if(!visited[nx][ny] && tempBoard[nx][ny] == '.'){
                                    visited[nx][ny] = true;
                                    queue.offer(new int[] {nx, ny});
                                }
                            }
                        }
                    }
                }
            }
        }

        return count;
    }
}
