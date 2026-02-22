import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, K;
    private static int[] bag;
    private static PriorityQueue<int[]> jewel = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2){
            if(o1[0]==o2[0]){ return o2[1]-o1[1]; }
            return o1[0]-o2[0];
        }
    });
    private static PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    private static long result=0;

    public static void main(String[] args) throws Exception {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        bag = new int[K];

        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            jewel.add(new int[]{Integer.parseInt(input[0]), Integer.parseInt(input[1])});
        }

        for(int i=0; i<K; i++){
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bag); // 가방 오름차순 정렬

        for(int i=0; i<K; i++){
            while(!jewel.isEmpty()){
                if(bag[i]<jewel.peek()[0]){ break; }
                pq.add(jewel.poll()[1]); // 가방에 보석 넣기 가능
            }
            // 가방마다 최대 한 개의 보석 가능
            if(!pq.isEmpty()){
                result += pq.poll();
            }
        }
        bw.write(result+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
