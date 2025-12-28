import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringBuilder sb = new StringBuilder();
    private static int N, M, MAX=Integer.MAX_VALUE;
    private static List<int[]>[] network;
    private static int[] dist; // 1->i node로 가는 최소 비용
    private static int[] recover; // 복구할 회선

    public static void main(String[] args) throws Exception{
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        network = new ArrayList[N+1];
        for(int i=0; i<=N; i++){
            network[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            int C = Integer.parseInt(input[2]);
            network[A].add(new int[] {B, C}); // A<->B : C
            network[B].add(new int[] {A, C});
        }

        dist = new int[N+1];
        Arrays.fill(dist, MAX);
        dist[1]=0;

        recover = new int[N+1];
        
        dijkstra();

        int cnt=0;
        for(int i=2; i<=N; i++){
            if(recover[i] != 0){
                cnt++;
                sb.append(i+" "+recover[i]+"\n");
            }
        }
        bw.write(cnt+"\n");
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    private static void dijkstra(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[] {1, 0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int curN = cur[0];
            int curC = cur[1];

            if(curC > dist[curN]){ continue; }

            for(int[] next : network[curN]){
                int nextN = next[0];
                int nextC = next[1];

                if (dist[nextN] > dist[curN]+nextC){
                    dist[nextN] = dist[curN]+nextC;
                    pq.add(new int[] {nextN, dist[nextN]});
                    recover[nextN] = curN;
                }

            }
        }
    }
}