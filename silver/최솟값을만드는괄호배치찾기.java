package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 최솟값을만드는괄호배치찾기 {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // eg. 55 - 50 + 40

        // '-' 기준으로 나눠서 담음
        //[55, 50 + 40]
        String[] numbers = br.readLine().split("-");

        for(int i=0; i<numbers.length; i++){
            if(numbers[i].contains("+")){
                int sum = 0;
                // + 가 있으면 묶어서 더해줌 (괄호 연산)
                String[] addNum = numbers[i].split("\\+");
                // [55, [50,40]]
                for(String addnum : addNum){
                    sum += Integer.parseInt(addnum);
                }
                // [55, 90]
                numbers[i] = Integer.toString(sum);
            }
        }

        int min = Integer.parseInt(numbers[0]);
        for(int i=1; i< numbers.length; i++){
            min -= Integer.parseInt(numbers[i]);
        }

        System.out.println(min);

    }
}
