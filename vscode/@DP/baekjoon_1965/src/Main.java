import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception{
        int N = Integer.parseInt(br.readLine());
        int[] box = new int[N];
        int[] dp = new int[N];

        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            box[i] = Integer.parseInt(input[i]);
        }

        int max=0;
        for(int i=0; i<N; i++){
            dp[i]=1;
            for(int j=0; j<i; j++){
                if(box[j] < box[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        bw.write(max+"\n");
        bw.flush();
        br.close();
        bw.close();

    }
}