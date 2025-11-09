import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);
        int M = Integer.parseInt(input[2]);
        int[] V  = new int[N+1];
        boolean[][] dp = new boolean[N+1][M+1];
        
        input = br.readLine().split(" ");
        for(int i=1; i<=N; i++){
            V[i] = Integer.parseInt(input[i-1]);
        }

        dp[0][S] = true;
        for(int i=1; i<=N; i++){
            for(int p=0; p<=M; p++){
                if(dp[i-1][p]){
                    int minus = p - V[i];
                    int plus  = p + V[i];
                    if(minus>=0) {dp[i][minus] = true; }
                    if(plus<=M ) {dp[i][plus]  = true; }
                }
            }
        }

        int max=-1;
        for(int i=0; i<=M; i++){
            if(dp[N][i]){ max = i; }
        }

        bw.write(max+"\n");
        bw.flush();
        
        br.close();
        bw.close();
    }
}
