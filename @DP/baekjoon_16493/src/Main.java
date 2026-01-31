import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception{
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 남은 일 수 
        int M = Integer.parseInt(input[1]); // 챕터 수 
        int[][] dp = new int[M+1][N+1];

        for(int i=1; i<=M; i++){
            input = br.readLine().split(" ");
            int day  = Integer.parseInt(input[0]);
            int page = Integer.parseInt(input[1]);
            
            for(int j=1; j<=N; j++){
                dp[i][j] = dp[i-1][j];
                if(j-day>=0){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-day]+page);
                }
            }
        }

        
        bw.write(dp[M][N]+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}