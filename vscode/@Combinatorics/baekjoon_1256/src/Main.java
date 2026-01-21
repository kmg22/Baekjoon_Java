import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringBuilder sb = new StringBuilder();
    private static int N, M, len;
    private static long K, MAX=1_000_000_001L;
    private static long[][] dp = new long[201][201];
    private static boolean flag=true;

    public static void main(String[] args) throws Exception {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);
        len = N+M;

        for(int i=0; i<=200; i++){
            dp[i][0] = 1;
            for(int j=1; j<=i; j++){
                dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
                if (dp[i][j] > MAX) dp[i][j] = MAX;
            }
        }

        // 가능한 조합 범위 초과
        if(dp[len][N]<K){
            flag=false;
            bw.write("-1\n");
        }

        if(flag){
            for(int i=0; i<len; i++){
                if(N>0){
                    long cnt = dp[N+M-1][M];
                    if(K<=cnt){
                        sb.append("a");
                        N--;
                    }else{
                        sb.append("z");
                        K -= cnt;
                        M--;
                    }
                }else{
                    sb.append("z");
                    M--;
                }
            }
            bw.write(sb.toString()+"\n");
        }


        bw.flush();
        br.close();
        bw.close();
    }

}
