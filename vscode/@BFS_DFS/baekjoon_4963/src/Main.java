import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[][] map;
    private static boolean[][] visit;
    static int w, h;
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};

    public static void BFS(int y, int x){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x});
        visit[y][x] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int i=0; i<8; i++){
                int tmpy = cur[0] + dx[i];
                int tmpx = cur[1] + dy[i];

                if(tmpx>=0 && tmpx<w && tmpy>=0 && tmpy<h){
                    if(map[tmpy][tmpx]==1 && !visit[tmpy][tmpx]){
                        q.offer(new int[]{tmpy, tmpx});
                        visit[tmpy][tmpx] = true;
                    }
                }       
            }
        }
    }

    public static void main(String[] args) throws Exception{
        String line;
        while((line=br.readLine())!=null && line.charAt(0)!='0'){
            String[] input = line.split(" ");
            w = Integer.parseInt(input[0]);
            h = Integer.parseInt(input[1]);
            
            map = new int[h][w];
            visit = new boolean[h][w];
            for(int i=0; i<h; i++){
                input = br.readLine().split(" ");
                for(int j=0; j<w; j++){
                    map[i][j] = Integer.parseInt(input[j]);
                }
            }

            int result=0;
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(map[i][j]==1 && !visit[i][j]){
                        BFS(i, j);
                        result++;
                    }
                }
            }
            bw.write(result+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}