import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] parking_charge = new int[M];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++){ // 주차장 단위 무게 당 요금
            parking_charge[i] = Integer.parseInt(br.readLine());
            pq.add(i);
        }

        int[][] car = new int[M+1][2];
        for(int i=1; i<=M; i++){ // 차량 무게 | 입주 주차장 번호
            car[i][0] = Integer.parseInt(br.readLine());
        }

        Queue<Integer> waiting = new LinkedList<>();
        for(int i=0; i<M*2; i++){
            int tmp = Integer.parseInt(br.readLine());
            if(tmp>0){ // 들어온 차량
                if(pq.size()>0){ // 자리 있다면
                    car[tmp][1] = pq.poll();
                }else{ // 자리 없다면
                    waiting.add(tmp);
                }
            }else{ // 나가는 차량
                pq.add(car[-tmp][1]); 
                if(waiting.size()>0){ // 대기 차량 존재하면
                    car[waiting.poll()][1] = pq.poll();
                }
            }
        }

        int total = 0;
        for(int i=1; i<=M; i++){
            total += car[i][0] * parking_charge[car[i][1]];
        }

        bw.write(total+"");
        bw.flush();

        br.close();
        bw.close();
    }
}