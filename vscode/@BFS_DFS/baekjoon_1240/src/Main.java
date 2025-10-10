import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, M;
    private static int[][] tree;
    private static boolean[] visit;

    private static int BFS(int n1, int n2){ // n1 -> n2 거리 구하기
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{n1, 0});
        visit[n1] = true;

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int node = tmp[0];
            int dist = tmp[1];
            if(node == n2){
                return dist;
            }

            for(int i=1; i<=N; i++){
                if(tree[node][i]>0 && !visit[i]){
                    q.offer(new int[]{i, dist + tree[node][i]});
                    visit[i] = true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception{
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]); // node 수
        M = Integer.parseInt(input[1]); // 거리 구하려는 node쌍 수

        tree = new int[N+1][N+1];
        for(int i=1; i<N; i++){
            input = br.readLine().split(" ");
            int n1 = Integer.parseInt(input[0]);
            int n2 = Integer.parseInt(input[1]);
            int dist = Integer.parseInt(input[2]);
            tree[n1][n2] = tree[n2][n1] = dist;
        }
        
        for(int i=0; i<M; i++){
            visit = new boolean[N+1];
            input = br.readLine().split(" ");
            int n1 = Integer.parseInt(input[0]);
            int n2 = Integer.parseInt(input[1]);
            bw.write(BFS(n1, n2)+"\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}