package CodingTest;

import java.util.*;

class Solution {
    public static int solution(String[] board){
        int max = Integer.MIN_VALUE;
        int N = board.length;
        char[][] A = new char[N][N];

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
                    count++;
                    now = A[j][i];
                }
            }
            boarderChange[0][i] = count;
        }

        // 가로 줄
        for(int i=0; i<N; i++){
            int count = 1;
            char now = A[i][0];
            for(int j=1; j<N; j++){
                if(now != A[i][j]) {
                    count++;
                    now = A[i][j];
                }
            }
            boarderChange[1][i] = count;
        }

        // 경계가 가장 많이 변한 횟수 찾기
        int changeMax = Arrays.stream(boarderChange)
                .flatMapToInt(Arrays::stream)
                .max()
                .getAsInt();

        ArrayList<int[]> candidate = new ArrayList<>();

        // 최댓값과 같은 좌표값 후보리스트에 저장
        for(int i=0; i<2; i++){
            for(int j=0; j<N; j++){
                if(boarderChange[i][j] == changeMax){
                    candidate.add(new int[] {i,j});
                }
            }
        }

        // 최대 빈칸 개수 찾기
        int maxEmpty = 0;
        for (int[] c : candidate) {
            maxEmpty = Math.max(maxEmpty, countRemovedBlocks(A, c[0], c[1]));
        }
        return maxEmpty;
    }

    private static int countRemovedBlocks(char[][] A, int type, int index) {
        int N = A.length;
        boolean[][] visited = new boolean[N][N];
        Set<int[]> removedBlocks = new HashSet<>();

        if (type == 0) { // 세로줄 삭제
            for (int i = 0; i < N; i++) {
                bfs(A, i, index, visited, removedBlocks);
            }
        } else { // 가로줄 삭제
            for (int i = 0; i < N; i++) {
                bfs(A, index, i, visited, removedBlocks);
            }
        }

        return removedBlocks.size();
    }

    private static void bfs(char[][] A, int x, int y, boolean[][] visited, Set<int[]> removedBlocks) {
        int N = A.length;
        if (visited[x][y]) return;

        Queue<int[]> queue = new LinkedList<>();
        char color = A[x][y];
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        Set<int[]> group = new HashSet<>();

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            group.add(now);
            int[] dx = {0, 0, -1, 1};
            int[] dy = {-1, 1, 0, 0};

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny] && A[nx][ny] == color) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        removedBlocks.addAll(group);
    }

    public static void main(String[] args) {
        String[] board = {
                "DDCCC",
                "DBBBC",
                "DBABC",
                "DBBBC",
                "DDCCC"
        };
        int len = board.length;
        System.out.println(solution(board)); // 예상 출력: 9
    }
}
