import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception{
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        dp[0]=0;
        for(int i=1; i<=N; i++){
            dp[i] = i; // 최악은 1²+1²+..
            for(int j=1; j*j<=i; j++){
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        
        bw.write(dp[N]+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}