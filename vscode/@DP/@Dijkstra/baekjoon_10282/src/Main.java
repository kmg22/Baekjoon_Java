import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int MAX = Integer.MAX_VALUE;
    private static List<int[]>[] network;
    private static int[] dist;
    private static int N, D, C;

    public static void main(String[] args) throws Exception{
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]); // 컴퓨터 개수
            D = Integer.parseInt(input[1]); // 의전성 개수
            C = Integer.parseInt(input[2]); // 해킹당한 컴퓨터 번호

            network = new ArrayList[N+1];
            for(int i=0; i<=N; i++){
                network[i] = new ArrayList<>();
            }

            for(int d=0; d<D; d++){
                input = br.readLine().split(" ");
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);
                int s = Integer.parseInt(input[2]);
                network[b].add(new int[] {a, s});
            }

            dist = new int[N+1];
            Arrays.fill(dist, MAX);
            dist[C] = 0;

            dijkstra();

            int time=0, cnt=0;
            for(int i=1; i <= N; i++){
                if(dist[i] != MAX){
                    cnt++;
                    time = Math.max(time, dist[i]);
                }
            }
            bw.write(cnt+" "+time+"\n");
        }
        
        bw.flush();
        br.close();
        bw.close();
    }

    private static void dijkstra(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1]-b[1]);
        pq.offer(new int[] {C, 0});

        while (!pq.isEmpty()) {
            int[] out = pq.poll();
            int cur = out[0];
            int curDist = out[1];

            if (curDist > dist[cur]) continue;

            for (int[] next : network[cur]) {
                int nextNode = next[0];
                int weight = next[1];
                
                if (dist[nextNode] > dist[cur] + weight) {
                    dist[nextNode] = dist[cur] + weight;
                    pq.offer(new int[]{nextNode, dist[nextNode]});
                }
            }
        }
    }
}