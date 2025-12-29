import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int mod = 100000;

    public static void main(String[] args) throws Exception{
        String[] input = br.readLine().split(" ");
        int w = Integer.parseInt(input[0]);
        int h = Integer.parseInt(input[1]);
        int[][][][] dp = new int[w+1][h+1][2][2]; // x좌표 | y좌표 | 현재방향(오른쪽:0|위:1) | 교차로 방향 변경 여부
        
        for(int i=1; i<=w; i++){
            dp[i][1][0][0]=1;
        }
        for(int i=1; i<=h; i++){
            dp[1][i][1][0]=1;
        }

        for(int i=2; i<=w; i++){
            for(int j=2; j<=h; j++){
                dp[i][j][0][0] = (dp[i-1][j][0][0]+dp[i-1][j][0][1])%mod;
                dp[i][j][0][1] = (dp[i-1][j][1][0])%mod;
                dp[i][j][1][0] = (dp[i][j-1][1][1]+dp[i][j-1][1][0])%mod;
                dp[i][j][1][1] = (dp[i][j-1][0][0])%mod;
            }
        }
        int result = (dp[w][h][0][0] + dp[w][h][0][1] + dp[w][h][1][0] + dp[w][h][1][1]) % mod;
        bw.write(result+"\n");

        bw.flush();
        br.close();
        bw.close();
    }
}