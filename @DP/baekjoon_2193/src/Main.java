import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i<=N; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }

        bw.write(dp[N]+"\n");

        bw.flush();
        br.close();
        bw.close();
    }
}