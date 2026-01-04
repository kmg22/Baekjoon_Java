import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, M, MAX=Integer.MAX_VALUE;
    private static List<int[]>[] edges;
    private static int[][] dist;    // i->j 최단 거리 비용
    private static int[][] first;   // i->j 최단 거리의 첫 이동지

    public static void main(String[] args) throws Exception {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]); // 집하장 개수
        M = Integer.parseInt(input[1]); // 경로 개수
        
        edges = new LinkedList[N+1];
        for(int i=0; i<=N; i++){
            edges[i] = new LinkedList<>();
        }

        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            int W = Integer.parseInt(input[2]);
            edges[A].add(new int[] {B, W});
            edges[B].add(new int[] {A, W});
        }

        dist = new int[N+1][N+1];
        first = new int[N+1][N+1];
        
        for(int i=1; i<=N; i++){
            Arrays.fill(dist[i], MAX);
            dist[i][i] = 0;
            dijkstra(i);
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(i==j){ 
                    bw.write("- ");
                    continue;
                }
                bw.write(first[i][j]+" ");
            }
            bw.write("\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static void dijkstra(int i){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[] {i, 0}); // targetNode | weight

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curN = cur[0];
            int curW = cur[1];

            if(curW > dist[i][curN]){ continue; }

            for(int[] next : edges[curN]){
                int nextN = next[0];
                int nextW = next[1];
                if(dist[i][nextN] > dist[i][curN] + nextW){
                    dist[i][nextN] = dist[i][curN] + nextW;
                    pq.add(new int[] {nextN, dist[i][nextN]});
                    
                    if(curW==0){
                        first[i][nextN] = nextN;
                    }
                    else{
                        first[i][nextN] = first[i][curN];
                    }
                }
            }
        }
    }
}
