import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            long[] dp = new long[N+3];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for(int i=4; i<=N; i++){
                dp[i] += (dp[i-1] + dp[i-2] + dp[i-3]) % 1_000_000_009;
            }
            bw.write(dp[N]+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
