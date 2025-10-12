import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, result=0;
    private static int[][] area;
    private static boolean[][] visit;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static void BFS(int x, int y, int h){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visit[x][y] = true;

        while(!q.isEmpty()){
            int[] tmp = q.poll();

            for(int i=0; i<4; i++){
                int tmpx = tmp[0] + dx[i];
                int tmpy = tmp[1] + dy[i];
                if(tmpx>=0 && tmpx<N && tmpy>=0 && tmpy<N){
                    if(area[tmpx][tmpy]>h && !visit[tmpx][tmpy]){
                        q.offer(new int[]{tmpx, tmpy});
                        visit[tmpx][tmpy] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());

        String[] input;
        area = new int[N][N];
        int maxH=0;
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                area[i][j] = Integer.parseInt(input[j]);
                maxH = Math.max(maxH, area[i][j]);
            }
        }

        for(int h=0; h<=maxH; h++){
            visit = new boolean[N][N];
            int cnt=0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(area[i][j]>h && !visit[i][j]){
                        BFS(i, j, h);
                        cnt++;
                    }
                }
            }
            result = Math.max(cnt, result);
        }

        bw.write(result+"\n");
        bw.flush();
        br.close();
        bw.close();
    }

}