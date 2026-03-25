import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[] dr = {-1, 1, 0, 0}; // 상 | 하 | 좌 | 우
    private static int[] dc = {0, 0, -1, 1};
    private static int N, M, V, MAX=100_000, result=100_000;
    private static String[] input;
    private static int[][] lab, time;
    private static ArrayList<int[]> virus = new ArrayList<>();
    private static boolean[][] active;

    public static void main(String[] args) throws Exception {
        input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        lab = new int[N][N];
        active = new boolean[N][N];

        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                lab[i][j] = Integer.parseInt(input[j]);
                if(lab[i][j]==2){ virus.add(new int[] {i, j}); }
            }
        }

        V = virus.size();
        combi(0, 0);

        result = result>=MAX?-1:result;
        bw.write(result+"\n");

        bw.flush();
        br.close();
        bw.close();
    }

    private static void combi(int start, int cnt){
        if(cnt == M){
            time = new int[N][N];
            for(int i=0; i<N; i++){ Arrays.fill(time[i], MAX); }
            spread();
            return;
        }

        for(int i=start; i<V; i++){
            int[] v = virus.get(i);
            active[v[0]][v[1]] = true;
            combi(i+1, cnt+1);
            active[v[0]][v[1]] = false;
        }

    }

    private static void spread(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(active[i][j]){
                    pq.add(new int[]{i, j, 0});
                    time[i][j] = 0;
                }
                
            }            
        }

        while(!pq.isEmpty()){
            int[] tmp = pq.poll();
            int tmpr = tmp[0];
            int tmpc = tmp[1];
            int tmpt = tmp[2];

            if(tmpt > time[tmpr][tmpc]){ continue; }

            for(int i=0; i<4; i++){
                int nextr = tmpr + dr[i];
                int nextc = tmpc + dc[i];

                if(nextr<0 || nextr>=N || nextc<0 || nextc>=N){ continue; }
                if(lab[nextr][nextc]==1){continue;}
                
                if(time[nextr][nextc] > time[tmpr][tmpc]+1){
                    time[nextr][nextc] = time[tmpr][tmpc]+1;
                    pq.add(new int[] {nextr, nextc, time[nextr][nextc]});
                }

            }
        }
        int cur = check();
        if(cur != -1){ result = Math.min(result, cur); }
        
    }

    private static int check(){
        int max=-1;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(lab[i][j]==1 || lab[i][j]==2){continue;}
                if(time[i][j]>=MAX){return -1;}
                max = Math.max(max, time[i][j]);
            }
        }
        return max==-1?0:max;
    }
}
