import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int V, E, a, b, c;
    private static int[][] dp;
    private static int MAX = Integer.MAX_VALUE/2;

    public static void main(String[] args) throws Exception {
        String[] input = br.readLine().split(" ");
        V = Integer.parseInt(input[0]);
        E = Integer.parseInt(input[1]);

        dp = new int[V+1][V+1];
        for(int i=0; i<=V; i++){
            Arrays.fill(dp[i], MAX);
        }
        for(int i=0; i<E; i++){
            input = br.readLine().split(" ");
            a = Integer.parseInt(input[0]);
            b = Integer.parseInt(input[1]);
            c = Integer.parseInt(input[2]);
            dp[a][b] = c;
        }

        // 각 정점간 최단 거리 계산
        for(int k=1; k<=V; k++){
            for(int i=1; i<=V; i++){
                for(int j=1; j<=V; j++){
                    if(i==j){ continue; }
                    
                    dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k][j]);
                }
            }
        }

        // 사이클 탐색
        int result = MAX;
        for(int i=1; i<=V; i++){
            for(int j=1; j<=V; j++){
                if(i==j){ continue; }

                if(dp[i][j]!=MAX && dp[j][i]!=MAX){
                    result = Math.min(result, dp[i][j]+dp[j][i]);
                }
            }
        }

        bw.write(( result>=MAX?-1:result ) +"\n");
        
        bw.flush();
        br.close();
        bw.close();
    }
}
