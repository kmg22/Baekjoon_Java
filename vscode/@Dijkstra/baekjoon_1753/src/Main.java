import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int V, E, K, MAX=Integer.MAX_VALUE;
    private static List<int[]>[] path; // 간선 정보
    private static int[] dist; // K->i 최소 비용
    
    public static void main(String[] args) throws Exception {
        String[] input = br.readLine().split(" ");
        V = Integer.parseInt(input[0]); // 정점 수
        E = Integer.parseInt(input[1]); // 간선 수
        K = Integer.parseInt(br.readLine()); // 시작 정점
        
        path = new ArrayList[V+1];
        for(int i=0; i<=V; i++){
            path[i] = new ArrayList<>();
        }

        for(int i=0; i<E; i++){
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);
            path[u].add(new int[] {v, w}); // u->v:w
        }

        dist = new int[V+1];
        Arrays.fill(dist, MAX);
        dist[K]=0;

        dijkstra();

        for(int i=1; i<=V; i++){
            if(dist[i]==MAX){
                bw.write("INF\n");
                continue;
            }
            bw.write(dist[i]+"\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static void dijkstra(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[] {K, 0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curV = cur[0];
            int curW = cur[1];

            if(curW > dist[curV]){ continue; }

            for(int[] next : path[curV]){
                int nextV = next[0];
                int nextW = next[1];
                if (dist[nextV] > dist[curV]+nextW){
                    dist[nextV] = dist[curV]+nextW;
                    pq.add(new int[] {nextV, dist[nextV]});
                }
            }
        }
    }
}
