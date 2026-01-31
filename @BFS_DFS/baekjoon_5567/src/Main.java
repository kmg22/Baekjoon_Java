import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, M;
    private static int[][] list;
    private static boolean[] visit;

    private static int BFS(int x){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, 0}); // 학번, 거리
        visit[x] = true;

        int cnt=0;
        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i=1; i<=N; i++){
                if(list[cur[0]][i]==1 && cur[1]<2 && !visit[i]){
                    q.offer(new int[]{i, cur[1]+1});
                    visit[i] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new int[N+1][N+1];
        visit = new boolean[N+1];
        for(int i=0; i<M; i++){
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            list[a][b] = list[b][a] = 1;
        }
        int result = BFS(1);
        bw.write(result+"\n");

        bw.flush();
        br.close();
        bw.close();
    }
}