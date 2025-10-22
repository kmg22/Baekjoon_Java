import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception{
        int N = Integer.parseInt(br.readLine());

        String[] Life = br.readLine().split(" "); // 체력
        String[] Joy = br.readLine().split(" "); // 기쁨

        int[] L = new int[N+1];
        int[] J = new int[N+1];

        int[][] dp = new int[N+1][100];
        for(int i=1; i<=N; i++){
            L[i] = Integer.parseInt(Life[i-1]);
            J[i] = Integer.parseInt(Joy[i-1]);
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<100; j++){
                dp[i][j] = dp[i-1][j];
                if(j>=L[i]){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-L[i]]+J[i]);
                }
            }
        }

        bw.write(dp[N][99]+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}