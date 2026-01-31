import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        int[][] tri = new int[N][N];
        int[][] dp  = new int[N][N];
        long max=0;
        String[] input;


        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<=i; j++){
                tri[i][j] = Integer.parseInt(input[j]);
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<=i; j++){
                int tmp1 = (i-1)>=0 && (j-1)>=0 ? dp[i-1][j-1] : 0;
                int tmp2 = (i-1)>=0  ? dp[i-1][j] : 0;
                dp[i][j] = Math.max(tmp1, tmp2) + tri[i][j];
            }
        }

        for(int j=0; j<N; j++){
            max = Math.max(max, dp[N-1][j]);
        }

        bw.write(max+"\n");
        bw.flush();
        
        br.close();
        bw.close();
    }
}
