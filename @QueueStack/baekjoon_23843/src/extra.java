import java.io.*;
import java.util.*;

public class extra {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        List<Integer> time = new ArrayList<>(); // 각 장치의 소요 시간
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 각 콘센트 이용 가능 시점 시간
        
        input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            int t = Integer.parseInt(input[i]);
            time.add(t);
        }
        Collections.sort(time, Collections.reverseOrder()); // 역순 저장(ex. 8 4 4 1 1)
        
        // 초기 콘센트 이용 가능 시점 : 0
        for(int i=0; i<M; i++){
            pq.add(0);
        }

        for(int t : time){ // (오래 걸리는 장치부터) 소요 시간
            int available_t = pq.poll(); // 이용 가능 시점 (빨리 끝나는 콘센트 시간)
            pq.add(available_t + t); // 예상 종료 시점 계산
        }

        int end_t = -1;
        while(!pq.isEmpty()){
            end_t = pq.poll();
        }

        bw.write(end_t+"\n");
        bw.flush();
        
        br.close();
        bw.close();
    }
}
