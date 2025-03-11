package silver;

import java.io.*;
import java.util.StringTokenizer;

public class 최대공약수 {
    static long A;
    static long B;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        long gcd = GCD(A,B);
        for(int i=0; i<gcd; i++){
            bw.write("1");
        }

        bw.flush();
        bw.close();

    }
    private static long GCD(long A, long B){
        if (B == 0){
            return A;
        }else{
            return GCD(B, A%B);
        }
    }
}
