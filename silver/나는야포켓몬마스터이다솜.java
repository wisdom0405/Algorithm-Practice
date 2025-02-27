package silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 나는야포켓몬마스터이다솜 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 1번째 줄 읽음

        int N = Integer.parseInt(st.nextToken()); // 포켓몬 개수
        int quiz = Integer.parseInt(st.nextToken()); // 문제 개수

        HashMap<String, Integer> nameMap = new HashMap<>(); // 포켓몬 이름, 번호저장 해시맵
        HashMap<Integer, String> numMap = new HashMap<>(); // 번호, 포켓몬 이름 해시맵

        for(int i=1; i<=N; i++){
            // 포켓몬 이름, 번호 저장 (순서대로 입력받음)
            st = new StringTokenizer(br.readLine()); // N번째 포켓몬
            String poketmon = st.nextToken(); // 포켓몬 이름
            nameMap.put(poketmon, i); // 포켓몬이름, N번
            numMap.put(i, poketmon); // N번, 포켓몬 이름
        }

        for(int i=0; i<quiz; i++){
            // 포켓몬 이름으로 물어보면 -> 포켓몬 번호 출력
            // 포켓몬 번호로 물어보면 -> 포켓몬 이름 출력
            String test =  br.readLine();

            if(test.charAt(0) >= 65){
                // 첫문자가 대문자로 시작한다면 이름문제 -> 번호 출력
                System.out.println(nameMap.get(test));
            }else{
                // 첫문자가 숫자로 시작한다면 번호문제 -> 이름 출력
                System.out.println(numMap.get(Integer.parseInt(test)));
            }
        }

    }
}
