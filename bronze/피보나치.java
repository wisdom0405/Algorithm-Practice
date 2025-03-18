package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = fiboDFS(n);
        System.out.println(result);
    }
    private static int fiboDFS(int n){
        if(n==0){
            return 0;
        } else if (n==1) {
            return 1;
        }else{
            return fiboDFS(n-1) + fiboDFS(n-2);
            // 0 1 1 2 3 5
        }
    }
}
