import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, M;
    private static int[][] graph;
    private static boolean[] visit;

    private static void BFS(int x){
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        visit[x] = true;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int i=0; i<=N; i++){
                if(graph[cur][i]==1 && !visit[i]){
                    q.offer(i);
                    visit[i] = true;
                }
            }
        }

    }
    public static void main(String[] args) throws Exception{
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        graph = new int[N+1][N+1];
        visit = new boolean[N+1];
        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            graph[x][y] = graph[y][x] = 1;
        }

        int cnt=0;
        for(int i=1; i<=N; i++){
            if(!visit[i]){
                BFS(i);
                cnt++;
            }
        }
        bw.write(cnt+"\n");
        bw.flush();

        br.close();
        bw.close();
    }
}