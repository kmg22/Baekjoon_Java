import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, M, MAX=Integer.MAX_VALUE;
    private static List<int[]>[] edges;
    private static int[] dist;      // 1->j 최단시간
    private static int[] parent;    // 역추적 방식 도입
    
    public static void main(String[] args) throws Exception {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]); // 지점 수
        M = Integer.parseInt(input[1]); // 도로 수
        
        edges = new LinkedList[N+1];
        for(int i=0; i<=N; i++){
            edges[i] = new LinkedList<>();
        }

        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            int T = Integer.parseInt(input[2]);
            edges[A].add(new int[] {B, T});
            edges[B].add(new int[] {A, T});
        }

        // 기준 최단시간
        parent = new int[N+1];
        dijkstra(0, 0);
        int normal = dist[N];

        // 최단 경로 간선 추출
        List<int[]> criticalEdges = new ArrayList<>();
        int cur = N;
        while(cur != 1){ // 1->N 경로 역추적
            criticalEdges.add(new int[] {parent[cur], cur});
            cur = parent[cur];
        }

        // 최단 경로 간선 막기
        int result=0;
        for(int[] bN : criticalEdges){
            dijkstra(bN[0], bN[1]);
            if(dist[N]>=MAX){
                result = -1;
                break;
            }
            result = Math.max(result, dist[N]-normal);
        }

        bw.write(result+"\n");
        bw.flush();
        br.close();
        bw.close();
    }

    private static void dijkstra(int bN1, int bN2){
        dist = new int[N+1];
        Arrays.fill(dist, MAX);
        dist[1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[] {1, 0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curN = cur[0];
            int curT = cur[1];

            if(curT > dist[curN]){ continue; }

            for(int[] next : edges[curN]){
                int nextN = next[0];
                int nextT = next[1];

                if((curN==bN1 && nextN==bN2) || (curN==bN2 && nextN==bN1)){ continue; }

                if(dist[nextN] > dist[curN]+nextT){
                    dist[nextN] = dist[curN]+nextT;
                    pq.add(new int[] {nextN, dist[nextN]});
                    if(bN1==0){ // 기준값 측정 상황(최단 경로 기록)
                        parent[nextN] = curN;
                    }
                }
            }
        }
    }
}
