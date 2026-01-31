import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 물품 개수
        int K = Integer.parseInt(input[1]); // 최대 무게
        int[][] dp = new int[N+1][K+1];
        

        for(int i=1; i<=N; i++){
            input = br.readLine().split(" ");
            int weight = Integer.parseInt(input[0]); // 무게
            int value  = Integer.parseInt(input[1]); // 가치

            for(int j=1; j<=K; j++){
                dp[i][j] = dp[i-1][j];
                if(j-weight>=0){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-weight]+value);
                }
            }
        }

        bw.write(dp[N][K]+"\n");
        bw.flush();
        
        br.close();
        bw.close();
    }
}