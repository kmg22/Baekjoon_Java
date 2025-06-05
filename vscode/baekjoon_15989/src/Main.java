import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        
        int[][] dp = new int[10001][4];
        dp[1][1] = dp[2][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;

        for(int i=4; i<10001; i++){
                dp[i][1] = dp[i-1][1];
                dp[i][2] = dp[i-2][1] + dp[i-2][2];
                dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
        }

        for(int c=0; c<T; c++){
            int N = Integer.parseInt(br.readLine());
            int sum = dp[N][1] + dp[N][2] + dp[N][3];
            bw.write(sum+"\n");
        }

        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}
