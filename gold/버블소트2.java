package gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 버블소트2 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 배열의 크기 N
        valueAndIndex[] A = new valueAndIndex[N]; // (값, index) 한번에 저장하는 사용자 정의 클래스 배열 선언
        int value = 0;

        // 원본배열 입력받기 (value, index)
        for(int i=0; i<N; i++){
            value = Integer.parseInt(br.readLine());
            A[i] = new valueAndIndex(value, i); // value, index 같이 저장
        }

        Arrays.sort(A); // A 오름차순 정렬 O(NlogN)

        int max = Integer.MIN_VALUE; // 왼쪽 이동칸수 max값

        for(int i=0; i<N; i++){
            max = Math.max(A[i].index - i, max);
        }

        System.out.println(max+1);
    }
}

class valueAndIndex implements Comparable<valueAndIndex>{
    // 원본 데이터의 값과 index값을 한번에 저장하는 클래스 선언 (+ 정렬조건 추가)
    int value; // data 원본 값
    int index; // data 원본 index (정렬 전 index)

    public valueAndIndex(int value, int index){
        super();
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(valueAndIndex o) {
        return this.value - o.value; // value 기준 오름차순 정렬
    }
}
