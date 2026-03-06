// floyd-warshall 방식
// O(N^3)

import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, M, a, b, c;
    private static String[] input;
    private static int[][] dp; // i->j 최소 비용
    private static final int MAX= Integer.MAX_VALUE / 2;
    
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine()); // 도시 수 (정점)
        M = Integer.parseInt(br.readLine()); // 버스 수 (간선)
            
        dp = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            Arrays.fill(dp[i], MAX);
            dp[i][i] = 0;
        }

        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");
            a = Integer.parseInt(input[0]);
            b = Integer.parseInt(input[1]);
            c = Integer.parseInt(input[2]);
            dp[a][b] = Math.min(dp[a][b], c);
        }

        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k][j]);
                }
            }
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                bw.write((dp[i][j]>=MAX ? 0 : dp[i][j]) + " ");
            }
            bw.newLine();
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}
