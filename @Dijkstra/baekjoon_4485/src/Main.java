import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, idx=1, result, MAX=1_000_000;
    private static int[][] map;
    private static String[] input;
    private static int[][] cost;
    private static int[] dr = {-1, 0, 1, 0};
    private static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception {

        while((N = Integer.parseInt(br.readLine()))>0){
            map = new int[N][N];
            for(int i=0; i<N; i++){
                input = br.readLine().split(" ");
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(input[j]);
                }
            }

            cost = new int[N][N];
            for(int i=0; i<N; i++){ Arrays.fill(cost[i], MAX); }
            cost[0][0] = map[0][0];

            search();
            bw.write("Problem "+(idx++)+": "+ cost[N-1][N-1] +"\n");

        }
        
        bw.flush();
        br.close();
        bw.close();
    }

    private static void search(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.add(new int[]{0, 0, cost[0][0]});

        while(!pq.isEmpty()){
            int[] tmp = pq.poll();
            int tmpr = tmp[0];
            int tmpc = tmp[1];
            int tmpcost = tmp[2];

            if(tmpcost > cost[tmpr][tmpc]){ continue; }

            for(int i=0; i<4; i++){
                int nextr = tmpr + dr[i];
                int nextc = tmpc + dc[i];
                if(!(nextr>=0 && nextr<N && nextc>=0 && nextc<N)){ continue; }
                if (cost[nextr][nextc] > cost[tmpr][tmpc] + map[nextr][nextc]){
                    cost[nextr][nextc] = cost[tmpr][tmpc] + map[nextr][nextc];
                    pq.add(new int[] {nextr, nextc, cost[nextr][nextc]});
                }
            }
        }
    }
}
