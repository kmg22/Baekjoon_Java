import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        int max = 100_001, mod=1_000_000_009;
        long[][] dp = new long[max][4];
        dp[1][1]=1; dp[1][2]=0; dp[1][3]=0;
        dp[2][1]=0; dp[2][2]=1; dp[2][3]=0;
        dp[3][1]=1; dp[3][2]=1; dp[3][3]=1;
        
        for(int i=4; i<max; i++){
                dp[i][1] = (dp[i-1][2]+dp[i-1][3])%mod;
                dp[i][2] = (dp[i-2][1]+dp[i-2][3])%mod;
                dp[i][3] = (dp[i-3][1]+dp[i-3][2])%mod;
        }

        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());

            long result = (dp[N][1]+dp[N][2]+dp[N][3])%mod;
            bw.write(result+"\n");
            
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
