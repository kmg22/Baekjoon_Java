import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static ArrayList<int[]>[] edges;
    private static int N;
    private static int[][] dp;
    private static String[] input;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1][2];

        edges = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            edges[i] = new ArrayList<>();
        }


        for(int i=1; i<N; i++){
            input = br.readLine().split(" ");
            int p = Integer.parseInt(input[0]);
            int c = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);
            edges[p].add(new int[]{c, w});
        }

        dfs(1);
        bw.write(dp[1][0]+"\n");

        bw.flush();
        br.close();
        bw.close();
    }

    private static int dfs(int idx){

        for(int[] node : edges[idx]){
            int tmp = dfs(node[0])+node[1];
            dp[idx][0] = Math.max(dp[idx][0], dp[node[0]][0]);
            dp[idx][0] = Math.max(dp[idx][0], dp[idx][1]+tmp);
            dp[idx][1] = Math.max(dp[idx][1], tmp);
        }

        return dp[idx][1];
    }
}
