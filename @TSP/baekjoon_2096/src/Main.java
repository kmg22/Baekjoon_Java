import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, Full, INF=16_000_000;
    private static int[][] w, dp;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        Full = 1<<N;
        dp = new int[Full][N]; // 순회 위해 남은 최소 거리
        w = new int[N][N];
        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                w[i][j] = Integer.parseInt(input[j]);
            }
        }

        for(int i=0; i<Full; i++){ Arrays.fill(dp[i], -1); }
        bw.write(dfs(1,0)+"\n");
        

        
        bw.flush();
        br.close();
        bw.close();
    }

    private static int dfs(int mask, int idx){
        if(mask == Full-1){ // 모든 지점 방문
            return w[idx][0]==0 ? INF : w[idx][0];
        }

        if(dp[mask][idx] != -1 ){ return dp[mask][idx]; } // 계산 안 한 상태 : -1 | 경로 없음 : INF
        dp[mask][idx] = INF;

        for(int i=0; i<N; i++){
            if((mask & (1<<i)) == 1 || w[idx][i] == 0){ continue; } // 다음 지점 방문 한 적 있거나 경로 없으면 pass
            dp[mask][idx] = Math.min(dp[mask][idx], dfs((mask|(1<<i)), i)+w[idx][i]);
        }
        return dp[mask][idx];
    }
}
