import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[] dp;

    private static int DP(int N){
        if(dp[N]>0) { return dp[N]; }

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i=4; i<=N; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        return dp[N];
    }
    
    public static void main(String[] args) throws Exception{
        int T = Integer.parseInt(br.readLine());

        dp = new int[11];
        DP(10);

        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            bw.write(DP(N)+"\n");
        }

        bw.flush();
        br.close();
        bw.close();    
    }
}