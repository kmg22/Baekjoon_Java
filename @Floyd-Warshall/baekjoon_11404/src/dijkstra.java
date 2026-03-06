// dijkstra 방식
// O(N·E log V)
// 간선이 적으면 빠름

import java.io.*;
import java.util.*;

public class dijkstra {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, M, a, b, c;
    private static String[] input;
    private static ArrayList<int[]>[] edges;
    private static int[][] dp; // i->j 최소 비용
    private static int MAX=Integer.MAX_VALUE;
    
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine()); // 도시 수 (정점)
        M = Integer.parseInt(br.readLine()); // 버스 수 (간선)
        
        edges = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            edges[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");
            a = Integer.parseInt(input[0]);
            b = Integer.parseInt(input[1]);
            c = Integer.parseInt(input[2]);
            edges[a].add(new int[] {b, c});
        }

        dp = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            Arrays.fill(dp[i], MAX);
            dp[i][i] = 0;
            func(i);
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                bw.write((dp[i][j]>=MAX ? 0 : dp[i][j]) + " ");
            }
            bw.newLine();
        }
        
        bw.flush();
        br.close();
        bw.close();
    }

    private static void func(int idx){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{idx, 0});

        while(!pq.isEmpty()){
            int[] tmp = pq.poll();
            int tmpN = tmp[0];
            int tmpC = tmp[1];

            if(tmpC > dp[idx][tmpN]){ continue; }

            for(int[] next : edges[tmpN]){
                int nextN = next[0];
                int nextC = next[1];
                if (dp[idx][nextN] > dp[idx][tmpN] + nextC){
                    dp[idx][nextN] = dp[idx][tmpN] + nextC;
                    pq.add(new int[] {nextN, dp[idx][nextN]});
                }
            }
        }
    }
}
