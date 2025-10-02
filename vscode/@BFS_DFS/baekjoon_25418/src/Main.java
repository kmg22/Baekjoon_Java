import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static int MAX_VALUE = 1_000_001;
    static boolean[] visit = new boolean[MAX_VALUE];

    public static int BFS(int A, int K){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {A,0}); // 값, 도달 최소 횟수
        visit[A] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            visit[cur[0]] = true;
            if(cur[0] == K){
                return cur[1];
            }

            if(cur[0]+1<=K && !visit[cur[0]+1]){
                q.offer(new int[] {cur[0]+1, cur[1]+1});
                visit[cur[0]+1] = true;
            }
            if(cur[0]*2<=K && !visit[cur[0]*2]){
                q.offer(new int[] {cur[0]*2, cur[1]+1});
                visit[cur[0]*2] = true;
            }
            
        }
        return -1;
    }

    public static void main(String[] args) throws Exception{
        
        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int cnt = BFS(A,K);

        bw.write(cnt+"\n");
        
        bw.flush();
        br.close();
        bw.close();
    }
}