import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[] dp;

    private static int DP(int n){
        if(dp[n]>0) {return dp[n];}
        for(int i=3; i<=n; i++){
            dp[i] = (dp[i-1] + dp[i-2]*2)%10007;
        }
        return dp[n];
    }
    
    public static void main(String[] args) throws Exception{
        int N = Integer.parseInt(br.readLine());
        dp = new int[N+2];
        dp[1] = 1;
        dp[2] = 3;

        int result = DP(N);
        bw.write(result+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}