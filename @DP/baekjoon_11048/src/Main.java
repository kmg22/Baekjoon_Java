import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[] dn = new int[] {-1, 0, -1};
    private static int[] dm = new int[] {0, -1, -1};
    public static void main(String[] args) throws Exception{
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[][] maze = new int[N+1][M+1];
        int[][] dp = new int[N+1][M+1];
        for(int i=1; i<=N; i++){
            input = br.readLine().split(" ");
            for(int j=1; j<=M; j++){
                maze[i][j] = Integer.parseInt(input[j-1]);
            }
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                dp[i][j] = maze[i][j];
                for(int c=0; c<3; c++){
                    int tmpN = i+dn[c];
                    int tmpM = j+dm[c];
                    if(tmpN>0 && tmpN<=N && tmpM>0 && tmpM<=M){
                        dp[i][j] = Math.max(dp[i][j], maze[i][j]+dp[tmpN][tmpM]);
                    }
                }
            }
        }
        bw.write(dp[N][M]+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}