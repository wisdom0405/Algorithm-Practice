import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 구간합구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()); // 1번째 줄 읽음

        int N = Integer.parseInt(st.nextToken()); // 데이터의 개수
        int quizeNum = Integer.parseInt(st.nextToken()); // 질의 개수

        long[] sumArr = new long[N+1]; // N+1 크기의 합배열 선언

        st = new StringTokenizer(br.readLine()); // 2번째 줄 읽음

        // 구간합 만들기
        for(int i=1; i <= N; i++){
            sumArr[i] = sumArr[i-1] + Integer.parseInt(st.nextToken());
        }

        // 질의개수 만큼 반복
        for(int i=0; i < quizeNum; i++){
            st = new StringTokenizer(br.readLine()); // 다음줄 읽기
            int n = Integer.parseInt(st.nextToken()); // n번째 수
            int m = Integer.parseInt(st.nextToken()); // m번째 수

            System.out.println(sumArr[m]-sumArr[n-1]);
        }
    }
}
