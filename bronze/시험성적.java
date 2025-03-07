package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 시험성적 {
    public static void main (String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 시험성적

        if(N >= 90 && N<= 100){
            System.out.println("A");
        }else if(N>= 80 && N<=89){
            System.out.println("B");
        }else if(N>= 70 && N<=79){
            System.out.println("C");
        }else if(N>= 60 && N<=69){
            System.out.println("D");
        }else{
            System.out.println("F");
        }
    }
}
