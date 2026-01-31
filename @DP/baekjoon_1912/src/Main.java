import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception{
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];

        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        dp[0] = arr[0];
        int max = dp[0];
        for(int i=1; i<N; i++){
            dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
            max = Math.max(max, dp[i]);
        }
        bw.write(max+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}