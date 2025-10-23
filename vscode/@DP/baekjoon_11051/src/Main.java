import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception{
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int[][] dp = new int[N+1][N+1];
        
        for(int n=1; n<=N; n++){
            dp[n][0] = 1;
            dp[n][n] = 1;
            for(int k=1; k<n && k<=K; k++){
                dp[n][k] = (dp[n-1][k] + dp[n-1][k-1])%10007;
            }
        }

        bw.write(dp[N][K]+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}