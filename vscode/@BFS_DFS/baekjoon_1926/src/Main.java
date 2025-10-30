import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, M;
    private static int[][] paper;
    private static boolean[][] visit;
    private static int[] dn = new int[] {-1, 1, 0, 0};
    private static int[] dm = new int[] {0, 0, -1, 1};
    
    private static int BFS(int n, int m){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{n, m});
        visit[n][m] = true;
        int area=0;

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            area++;

            for(int i=0; i<4; i++){
                int tmpN = tmp[0] + dn[i];
                int tmpM = tmp[1] + dm[i];
                if(tmpN>=0 && tmpN<N && tmpM>=0 && tmpM<M){
                    if(paper[tmpN][tmpM]>0 && !visit[tmpN][tmpM]){
                        q.add(new int[] {tmpN, tmpM});
                        visit[tmpN][tmpM] = true;
                    }
                }
            }
        }
        return area;
    }
    public static void main(String[] args) throws Exception{
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        int cnt=0, area=0;
        paper = new int[N][M];
        visit = new boolean[N][M];

        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                paper[i][j] = Integer.parseInt(input[j]);
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(paper[i][j]>0 && !visit[i][j]){
                    area = Math.max(area, BFS(i, j));
                    cnt++;
                }
            }
        }
        bw.write(cnt+"\n");
        bw.write(area+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}