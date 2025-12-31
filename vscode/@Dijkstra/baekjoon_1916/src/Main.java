import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, M, start, end, MAX=Integer.MAX_VALUE;
    private static List<int[]>[] edges;
    private static String[] input;
    private static int[] dist; // start->i 최소 비용

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        edges = new LinkedList[N+1];
        for(int i=0; i<=N; i++){
            edges[i] = new LinkedList<>();
        } 

        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");
            start = Integer.parseInt(input[0]);
            end = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);
            edges[start].add(new int[] {end, w});
        }

        input = br.readLine().split(" ");
        start = Integer.parseInt(input[0]);
        end = Integer.parseInt(input[1]);


        dist = new int[N+1];
        Arrays.fill(dist, MAX);
        dist[start] = 0;
        dijkstra();

        bw.write(dist[end]+"\n");

        bw.flush();
        br.close();
        bw.close();
    }

    private static void dijkstra(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[] {start, 0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curN = cur[0];
            int curW = cur[1];

            if(curW > dist[curN]){ continue; }

            for(int[] next: edges[curN]){
                int nextN = next[0];
                int nextW = next[1];

                if (dist[nextN] > dist[curN]+nextW){
                    dist[nextN] = dist[curN]+nextW;
                    pq.add(new int[] {nextN, dist[nextN]});
                }
            }
        }
    }
}