import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int T, N, M;
    private static String[] input;
    
    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            // 값 할당
            N = Integer.parseInt(br.readLine()); // 코인 종류
            int[] coins = new int[N+1];

            input = br.readLine().split(" ");
            for(int i=1; i<=N; i++){
                coins[i] = Integer.parseInt(input[i-1]); // 코인 금액
            }
            
            M = Integer.parseInt(br.readLine()); // 목표 금액
            int[][] dp = new int[N+1][M+1];
            
            for(int i=1; i<=N; i++){
                dp[i][0] = 1;
                for(int j=1; j<=M; j++){
                    dp[i][j] = dp[i-1][j];
                    if(j>=coins[i]){
                        dp[i][j] += dp[i][j-coins[i]];
                    }
                }
            }
            bw.write(dp[N][M]+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
