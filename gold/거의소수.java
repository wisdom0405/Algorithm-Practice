package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 거의소수 {
    static long count;
    static long start;
    static long end;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Long.parseLong(st.nextToken());
        end = Long.parseLong(st.nextToken());

        ArrayList<Long> primeList = new ArrayList<>();

        // 소수인 것만 리스트에 넣기
        for(long i=start; i<=end; i++){
            if(isPrime(i)){
                primeList.add(i);
            }
        }

        // 리스트 돌면서 거의 소수인 것 찾기
        count = 0;

        for(int i=0; i<primeList.size(); i++){
            almostPrime(primeList.get(i),2);
        }

        System.out.println(count);

    }
    static boolean isPrime(long num){
        if(num == 1) return false; // 1은 소수아님
        if(num == 2 || num == 3) return true; // 2,3은 소수
        for(long i=2; i<=Math.sqrt(num); i++){
            if (num % i == 0) return false; // 나누어떨어지는 수 있으면 소수아님
        }
        return true;
    }

    static void almostPrime(double prime, double n){
        double almostPrime = Math.pow(prime, n);
        if(almostPrime > end) return;
        while (almostPrime <= end) {
                count++;
                n++;
                almostPrime(prime, n);
        }
    }
}
