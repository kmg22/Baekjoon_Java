import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N;
    private static int[][] dp;
    private static boolean[] visited;
    private static ArrayList<Integer>[] relation;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1][2];

        relation = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            relation[i] = new ArrayList<Integer>();
        }

        for(int i=1; i<N; i++){
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            relation[input[0]].add(input[1]);
            relation[input[1]].add(input[0]);
        }

        dfs(0,1);
        bw.write(Math.min(dp[1][0], dp[1][1])+"\n");
        
        bw.flush();
        br.close();
        bw.close();
    }

    private static void dfs(int parent, int x){
        dp[x][0] = 0; // x:early x
        dp[x][1] = 1; // x:early o

        for(int next : relation[x]){
            if(next == parent) continue;
            
            dfs(x, next);
            dp[x][0] += dp[next][1];                        // x:early x => 연결된 노드는 early여야 함
            dp[x][1] += Math.min(dp[next][0], dp[next][1]); // x:early o => 연결된 노드는 early 상관없이 최적의 값
        }
    }

    
}
