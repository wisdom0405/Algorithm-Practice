package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소비용구하기2 {
    static int N,E;
    static int depart, destination;
    static ArrayList<City>[] A;
    static int[] cost;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 도시개수(노드)
        E = Integer.parseInt(br.readLine()); // 버스개수(에지)
        A = new ArrayList[N+1]; // 버스번호 1부터 시작
        cost = new int[N+1]; // 최소비용 배열

        // 인접노드리스트 초기화
        for(int i=1; i<N+1; i++){
            A[i] = new ArrayList<>();
        }

        int start, end, busCost;
        StringTokenizer st;
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken()); // 출발도시번호
            end = Integer.parseInt(st.nextToken()); // 도착도시번호
            busCost = Integer.parseInt(st.nextToken()); // 버스비용

            A[start].add(new City(end, busCost));
        }

        int max = Integer.MAX_VALUE;
        Arrays.fill(cost, max); // max 값으로 모두 채우기

        st = new StringTokenizer(br.readLine());
        depart = Integer.parseInt(st.nextToken()); // 출발도시번호
        destination = Integer.parseInt(st.nextToken()); // 도착도시번호
        cost[depart] = 0; // 출발도시번호만 거리0으로 초기화

        // 다익스트라 수행
        dijkstra(depart);
        System.out.println(cost[destination]);
    }
    private static void dijkstra (int depart){
        PriorityQueue<City> q = new PriorityQueue<>();
        q.offer(new City(depart, 0));

        while (!q.isEmpty()){
            City now = q.poll(); // 현재노드

            // 현재 노드의 최단 경로가 이미 더 짧다면 무시
            if(now.getCost() > cost[now.getNumber()]) continue;

            for(City next : A[now.getNumber()]){
                int newCost = cost[now.getNumber()] + next.getCost();
                if(newCost < cost[next.getNumber()]){
                    cost[next.getNumber()] = newCost;
                    q.add(new City(next.getNumber(), newCost)); // 새로운 경로추가
                }
            }
        }
    }
}
class City implements Comparable<City>{
    int number;
    int cost;

    public City(int number, int cost){
        super();
        this.number = number;
        this.cost = cost;
    }

    public int getNumber(){
        return this.number;
    }

    public int getCost(){
        return this.cost;
    }

    @Override
    public int compareTo(City o) {
        return this.cost - o.cost; // 비용 오름차순 정렬
    }
}
