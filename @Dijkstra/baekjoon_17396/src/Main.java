import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static List<Node>[] edges;
    private static long[] time;
    private static int N, M;
    private static long MAX=Long.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        edges = new LinkedList[N];
        for(int i=0; i<N; i++){
            edges[i] = new LinkedList<>();
        }
        
        boolean[] possible = new boolean[N];
        input = br.readLine().split(" ");
        for(int i=0; i<N-1; i++){
            possible[i] = Integer.parseInt(input[i])==0 ? true : false;
        }
        possible[N-1] = true;

        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int t = Integer.parseInt(input[2]);
            if(possible[a] && possible[b]){
                edges[a].add(new Node(b, t));
                edges[b].add(new Node(a, t));
            }
        }

        time = new long[N]; // 0->i 최소 시간
        Arrays.fill(time, MAX);
        time[0]=0;

        dijkstra();

        long result=time[N-1];
        if(result>=MAX){ result = -1; }
        bw.write(result+"\n");

        bw.flush();
        br.close();
        bw.close();
    }

    private static void dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int curN = cur.node;
            long curT = cur.time;

            if(curT > time[curN]){ continue; }

            for(Node next : edges[curN]){
                int nextN = next.node;
                long nextT = next.time;
                if (time[nextN] > time[curN]+nextT){
                    time[nextN] = time[curN]+nextT;
                    pq.add(new Node(nextN, time[nextN]));
                }
            }
        }
    }

    private static class Node implements Comparable<Node>{
        int node;
        long time;

        Node(int node, long time){
            this.node = node;
            this.time = time;
        }

        @Override
        public int compareTo(Node o){
            return Long.compare(this.time, o.time);
        }
    }
}