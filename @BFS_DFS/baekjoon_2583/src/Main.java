import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int M, N, K;
    private static int[][] area;
    private static boolean[][] visit;
    private static int[] nx = {-1, 1, 0, 0};
    private static int[] ny = {0, 0, -1, 1};

    private static int BFS(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x});
        visit[y][x] = true;

        int cnt=0;
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            cnt++;

            for(int i=0; i<4; i++){
                int tmpy = tmp[0] + ny[i];
                int tmpx = tmp[1] + nx[i];
                
                if(tmpx>=0 && tmpx<N && tmpy>=0 && tmpy<M){
                    if(area[tmpy][tmpx]!=1 && !visit[tmpy][tmpx]){
                        q.offer(new int[]{tmpy, tmpx});
                        visit[tmpy][tmpx] = true;
                    }
                }
            }

        }
        return cnt;
    }
    public static void main(String[] args) throws Exception{
        String[] input = br.readLine().split(" ");
        
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);

        area = new int[M][N];
        visit = new boolean[M][N];

        for(int i=0; i<K; i++){
            input = br.readLine().split(" ");
            int x1 = Integer.parseInt(input[0]);
            int y1 = Integer.parseInt(input[1]);
            int x2 = Integer.parseInt(input[2]);
            int y2 = Integer.parseInt(input[3]);
            for(int tmpy=y1; tmpy<y2; tmpy++){
                for(int tmpx=x1; tmpx<x2; tmpx++){
                    area[tmpy][tmpx] = 1;
                }
            }
        }
        
        int cnt=0;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(area[i][j]!=1 && !visit[i][j]){
                    list.add(BFS(i, j));
                    cnt++;
                }
            }
        }

        Collections.sort(list);
        bw.write(cnt+"\n");
        for(int n : list){
            bw.write(n+" ");
        }
        bw.newLine(); 
        bw.flush();
        br.close();
        bw.close();
    }
}