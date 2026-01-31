import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        String[] input;

        int[][] RGB = new int[N][3];
        int[][] dp  = new int[N][3];
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            RGB[i][0] = Integer.parseInt(input[0]);
            RGB[i][1] = Integer.parseInt(input[1]);
            RGB[i][2] = Integer.parseInt(input[2]);
        }

        dp[0][0] = RGB[0][0];
        dp[0][1] = RGB[0][1];
        dp[0][2] = RGB[0][2];
        for(int i=1; i<N; i++){
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][1] = Integer.MAX_VALUE;
            dp[i][2] = Integer.MAX_VALUE;
            for(int color=0; color<3; color++){ // i집 color 선택
                for(int p=1; p<3; p++){ // i-1집 color 선택
                    int other = (color+p)%3;
                    dp[i][color] = Math.min(dp[i][color], dp[i-1][other]+RGB[i][color]);
                }
            }
        }
        
        int result = Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2]));
        bw.write(result+"\n");
        bw.flush();

        br.close();
        bw.close();
    }
}
