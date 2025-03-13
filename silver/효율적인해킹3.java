package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 효율적인해킹3 {
    static int N, E;
    static boolean[] visited; // 방문배열
    static ArrayList<Integer>[] A;
    static int[] hackCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 노드개수
        E = Integer.parseInt(st.nextToken()); // 에지개수
        A = new ArrayList[N + 1];
        hackCount = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine()); // 새로운 줄 읽어들임
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            // A -> B 신뢰하는 경우, B를 해킹하면 A도 해킹할 수 있다.
            // 역방향으로 인접리스트 값 입력
            A[node2].add(node1);
        }

        for (int i = 1; i < N + 1; i++) {
            visited = new boolean[N + 1]; // 방문배열 초기하
            hackCount[i] = DFS(i);
        }

        int max = Arrays.stream(hackCount).max().getAsInt();
        for (int i = 1; i < N + 1; i++) {
            if (hackCount[i] == max) {
                System.out.print(i + " ");
            }
        }
    }

    private static int DFS(int i) {
        visited[i] = true;
        int count = 1; // 자기 자신도 포함

        for (int next : A[i]) {
            if (!visited[next]) {
                // 방문하지 않은 노드라면
                count += DFS(next);
            }
        }
        return count;
    }
}