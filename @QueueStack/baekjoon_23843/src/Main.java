import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] concent = new int[M];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            int time = Integer.parseInt(input[i]);
            pq.add(time);
        }
        
        int cnt=0, on=M;
        while(!pq.isEmpty() || on>0){
            on = 0; // 충전이 남아 있는 장치 수
            for(int i=0; i<M; i++){
                if(--concent[i]>0){
                    on++;
                    continue;
                }

                // 충전 가능한 concent case
                if(!pq.isEmpty()){
                    concent[i] = pq.poll();
                    on++;
                }
            }
            cnt++;
        }
        cnt--;
        bw.write(cnt+"\n");
        
        bw.flush();
        br.close();
        bw.close();
    }
}
