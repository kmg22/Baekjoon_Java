import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, E, v1, v2, MAX=Integer.MAX_VALUE/3;
    private static ArrayList<int[]>[] edges;
    private static int[] dist;

    public static void main(String[] args) throws Exception{
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        E = Integer.parseInt(input[1]);

        edges = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            edges[i] = new ArrayList<>();
        }

        for(int i=0; i<E; i++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            edges[a].add(new int[]{b, c});
            edges[b].add(new int[]{a, c});
        }

        input = br.readLine().split(" ");
        v1 = Integer.parseInt(input[0]);
        v2 = Integer.parseInt(input[1]);

        dist = new int[N+1];
        
        // 1 -> v1 -> v2 -> N
        // 1 -> v2 -> v1 -> N

        Arrays.fill(dist, MAX);
        dijkstra(1);
        int result1 = dist[v1];
        int result2 = dist[v2];

        Arrays.fill(dist, MAX);
        dijkstra(v1);
        result1 += dist[v2];
        result2 += dist[N];
        
        Arrays.fill(dist, MAX);
        dijkstra(v2);
        result1 += dist[N];
        result2 += dist[v1];

        if(result1<MAX || result2<MAX){
            bw.write(Math.min(result1, result2) +"\n");
        } else{ bw.write("-1\n"); }        

        bw.flush();
        br.close();
        bw.close();
    }

    private static void dijkstra(int i){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        boolean[] visited = new boolean[N+1];
        pq.add(new int[] {i,0});
        dist[i] = 0;

        while(!pq.isEmpty()){
            int[] tmp = pq.poll();
            int tmpn = tmp[0];
            int tmpc = tmp[1];

            if(visited[tmpn]) continue;
            visited[tmpn] = true;

            for(int[] next : edges[tmpn]){
                int nextn = next[0];
                int nextc = next[1];
                
                if (dist[nextn] > dist[tmpn] + nextc){
                    dist[nextn] = dist[tmpn] + nextc;
                    pq.add(new int[]{nextn, dist[nextn]});
                }
            }
        }
    }
}