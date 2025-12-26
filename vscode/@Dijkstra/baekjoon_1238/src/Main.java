import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, M, X, MAX=Integer.MAX_VALUE;
    private static List<int[]>[] to;
    private static List<int[]>[] from;

    public static void main(String[] args) throws Exception {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        X = Integer.parseInt(input[2]);

        to = new ArrayList[N+1];
        from = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            to[i] = new ArrayList<>();
            from[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int time = Integer.parseInt(input[2]);

            to[end].add(new int[] {start, time});
            from[start].add(new int[] {end, time});
        }
        
        int[] min_toX = dijkstra(to);
        int[] min_fromX = dijkstra(from);

        int result=0;
        for(int i=1; i<=N; i++){
            result = Math.max(result, min_toX[i] + min_fromX[i]);
        }

        bw.write(result+"\n");
        bw.flush();

        br.close();
        bw.close();
    }

    private static int[] dijkstra(List<int[]>[] path){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[] {X, 0});

        int[] dist = new int[N+1];
        Arrays.fill(dist, MAX);
        dist[X] = 0;

        while(!pq.isEmpty()){
            int[] out = pq.poll();
            int cur = out[0];
            int curDist = out[1];

            if(curDist > dist[cur]){ continue; }

            for(int[] edge : path[cur]){
                int prev = edge[0];
                int time = edge[1];

                if (dist[prev] > dist[cur] + time){
                    dist[prev] = dist[cur] + time;
                    pq.offer(new int[] {prev, dist[prev]});
                }
            }
        }

        return dist;
    }
}
