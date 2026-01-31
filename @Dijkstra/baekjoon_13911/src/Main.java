import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static List<int[]>[] path;
    private static int V, E, M, X, S, Y, MAX=Integer.MAX_VALUE;
    private static boolean[] isHouse;

    public static void main(String[] args) throws Exception{
        String[] input = br.readLine().split(" ");
        V = Integer.parseInt(input[0]);
        E = Integer.parseInt(input[1]);

        path = new ArrayList[V+1];
        for(int i=0; i<=V; i++){
            path[i] = new ArrayList<>();
        }

        for(int i=0; i<E; i++){
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);
            // u<->v : w
            path[v].add(new int[] {u, w}); 
            path[u].add(new int[] {v, w}); 
        }

        isHouse = new boolean[V+1];
        Arrays.fill(isHouse, true);

        // 맥도날드 정보
        input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        X = Integer.parseInt(input[1]);

        int[] mVertex = new int[M];
        int[] distM = new int[V+1];
        Arrays.fill(distM, MAX);

        input = br.readLine().split(" ");
        for(int i=0; i<M; i++){
            int pos = Integer.parseInt(input[i]);
            mVertex[i] = pos;
            distM[pos] = 0;
            isHouse[pos] = false;
        }

        // 스타벅스 정보
        input = br.readLine().split(" ");
        S = Integer.parseInt(input[0]);
        Y = Integer.parseInt(input[1]);

        int[] sVertex = new int[S];
        int[] distS = new int[V+1];
        Arrays.fill(distS, MAX);
        
        input = br.readLine().split(" ");
        for(int i=0; i<S; i++){
            int pos = Integer.parseInt(input[i]);
            sVertex[i] = pos;
            distS[pos] = 0;
            isHouse[pos] = false;
        }

        dijkstra(mVertex, distM);
        dijkstra(sVertex, distS);

        int result=MAX;
        for(int i=1; i<=V; i++){
            if(isHouse[i] && distM[i]<=X && distS[i]<=Y){
                result = Math.min(result, distM[i]+distS[i]);
            }
        }

        if(result>=MAX){ bw.write(-1+"\n"); }
        else{ bw.write(result+"\n"); }

        bw.flush();
        br.close();
        bw.close();
    }

    private static void dijkstra(int[] store, int[] dist){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        for(int i=0; i<store.length; i++){
            pq.add(new int[] {store[i], 0});
        }

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curV = cur[0];
            int curW = cur[1];

            if(curW>dist[curV]){ continue; }

            for(int[] tmp : path[curV]){
                int tmpV = tmp[0];
                int tmpW = tmp[1];
                if (dist[tmpV] > dist[curV]+tmpW){
                    dist[tmpV] = dist[curV]+tmpW;
                    pq.add(new int[] {tmpV, dist[tmpV]});
                }
            }
        }
    }
}