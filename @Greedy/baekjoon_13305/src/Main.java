import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        long[] distance = new long[N-1]; // 도시 사이 거리
        long[] price = new long[N-1]; // 도시 별 주요소 가격
        long money=0, min_price=Long.MAX_VALUE;

        String[] input = br.readLine().split(" ");
        for(int i=0; i<N-1; i++){
            distance[i] = Long.parseLong(input[i]);
        }

        input = br.readLine().split(" ");
        for(int i=0; i<N-1; i++){ // 마지막 주요소는 충전할 일 없으므로 무의미
            price[i] = Long.parseLong(input[i]);
        }

        min_price = price[0]; // 지금까지 중 가장 저렴한 요금

        for(int i=0; i<N-1; i++){
            min_price = Math.min(min_price, price[i]);
            money += distance[i] * min_price;
        }

        bw.write(money+"\n");
        bw.flush();
        
        br.close();
        bw.close();
    }
}
