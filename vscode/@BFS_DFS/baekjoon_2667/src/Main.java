import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N;
    private static int[][] map;
    private static boolean[][] visit;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    private static int BFS(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visit[x][y] = true;

        int town=1;
        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i=0; i<4; i++){
                int curx = cur[0] + dx[i];
                int cury = cur[1] + dy[i];

                if(curx>=1 && curx<=N && cury>=1 && cury<=N){
                    if(map[curx][cury]==1 && !visit[curx][cury]){
                        q.offer(new int[]{curx, cury});
                        visit[curx][cury] = true;
                        town++;
                    }
                }
            }
        }
        return town;
    } 

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];
        visit = new boolean[N+1][N+1];

        for(int i=1; i<=N; i++){
            String[] input = br.readLine().split("");
            for(int j=1; j<=N; j++){
                map[i][j] = Integer.parseInt(input[j-1]);
                
            }
        }

        int cnt=0;
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(map[i][j]==1 && !visit[i][j]){
                    list.add(BFS(i, j));
                    cnt++;
                }
            }
        }
        Collections.sort(list);

        bw.write(cnt+"\n");
        for(int i=0; i<cnt; i++){
            bw.write(list.get(i)+"\n");
        }

        bw.flush();
        br.close();
        bw.close();    
    }
}