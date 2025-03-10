package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최소공배수 {
    static int A;
    static int B;
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 질의 개수

        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            int gcd = GCD(A,B);
            int result = A*B/gcd;
            System.out.println(result);
        }
    }
    private static int GCD(int A, int B) {
        if (B == 0) return A;
        else {
            return GCD(B, A % B);
        }
    }
}
