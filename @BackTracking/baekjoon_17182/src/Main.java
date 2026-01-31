import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, K, result=Integer.MAX_VALUE;
    private static int[][] time;
    private static boolean[] visited;

    public static void main(String[] args) throws Exception {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        visited = new boolean[N];
        time = new int[N][N];

        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                time[i][j] = Integer.parseInt(input[j]);
            }
        }

        // i->j 최단 거리 갱신
        update();

        // 모든 행성 탐사하는 최단거리 탐색
        visited[K] = true;
        backtracking(1, K, 0);

        bw.write(result+"\n");

        bw.flush();
        br.close();
        bw.close();
    }

    private static void update(){
        for(int k=0; k<N; k++){
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(time[i][j] > time[i][k]+time[k][j]){
                        time[i][j] = time[i][k]+time[k][j];
                    }
                }
            }
        }
    }

    private static void backtracking(int cnt, int last, int cost){
        if(cost>=result){ return; }

        if(cnt==N){
            result = Math.min(result, cost);
            return;
        }

        for(int i=0; i<N; i++){
            if(visited[i]){ continue; }

            visited[i] = true;
            backtracking(cnt+1, i, cost+time[last][i]);
            visited[i] = false;
        }
    }


}
