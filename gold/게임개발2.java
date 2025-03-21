package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 게임개발2 {
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 건물 갯수 (노드)

        ArrayList<Building>[] A = new ArrayList[N+1]; // 건물번호 1부터 시작
        int[] indegree = new int[N+1]; // 진입차수 기록 배열
        int[] result = new int[N+1];

        // 인접노드 리스트 만들어주기
        for(int i=1; i<N+1; i++){
            A[i] = new ArrayList<>();
        }

        StringTokenizer st;
        // 건물정보 받기
        for(int i=1; i<N+1; i++){
            st = new StringTokenizer(br.readLine());
            int takeTime = Integer.parseInt(st.nextToken()); // 첫번째 토큰은 건물짓는데 소요되는 시간
            Building building = new Building(i, takeTime);
        }
    }

}
class Building{
    int number;
    int time;

    public Building(int number, int time){
        super();
        this.number = number;
        this.time = time;
    }

    public int getNumber(){
        return number;
    }

    public int getTime(){
        return time;
    }
}
