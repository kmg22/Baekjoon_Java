import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    private static int[][] maze;
    private static boolean[][] visit;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static int BFS(int x, int y, int N, int M){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y, 1});
        visit[x][y] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curx = cur[0];
            int cury = cur[1];
            int dist = cur[2];

            if(curx==N && cury==M){
                return dist;
            }

            for(int i=0; i<4; i++){
                int nx = curx + dx[i];
                int ny = cury + dy[i];
                if(nx>=1 && nx<=N && ny>=1 && ny<=M){
                    if(maze[nx][ny]==1 && !visit[nx][ny]){
                        q.offer(new int[]{nx, ny, dist+1});
                        visit[nx][ny] = true;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception{
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        maze = new int[N+1][M+1];
        visit = new boolean[N+1][M+1];
        for(int i=1; i<=N; i++){
            input = br.readLine().split("");
            for(int j=1; j<=M; j++){
                maze[i][j] = Integer.parseInt(input[j-1]);
            }
        }
        int result = BFS(1, 1, N, M);
        bw.write(result+"\n");
        
        bw.flush();
        br.close();
        bw.close();
    }
}