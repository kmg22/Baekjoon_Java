import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, size=2, result=0;
    private static int[][] space;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());

        int startX=0, startY=0;
        space = new int[N][N];
        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" "); 
            for(int j=0; j<N; j++){
                space[i][j] = Integer.parseInt(input[j]);
                if(space[i][j]==9){ // 아기상어 시작 위치
                    startY=i;
                    startX=j;
                    space[i][j]=0;
                }
            }
        }

        BFS(startX, startY);
        bw.write(result+"\n");
        bw.flush();
        br.close();
        bw.close();
    }

    private static void BFS(int x, int y){
        int eat=0;
        int curX=x, curY=y, curM=0;

        while(true){
            PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a,b)->
                a[2]!=b[2] ? a[2]-b[2] : (a[0]!=b[0] ? a[0]-b[0] : a[1]-b[1])
            );
            visited = new boolean[N][N];

            pq.add(new int[] {curY, curX, 0});
            visited[curY][curX]=true;
            boolean hasPrey = false;

            while(!pq.isEmpty()){
                int[] cur = pq.poll();
                curY = cur[0];
                curX = cur[1];
                curM = cur[2];
                
                // 먹을 수 있는 먹이 존재
                if(0<space[curY][curX] && space[curY][curX]<size){ 
                    space[curY][curX] = 0;
                    eat++;
                    hasPrey = true;
                    result += curM;

                    if(size==eat){
                        size++;
                        eat=0;
                    }
                    // 물고기 먹을때마다 초기화
                    break;
                }

                // 이동가능한 주변 살피기
                for(int i=0; i<4; i++){
                    int nY = curY+dy[i];
                    int nX = curX+dx[i];
                    int nM = curM+1;
                    if(nX>=0 && nX<N && nY>=0 && nY<N){
                        if(!visited[nY][nX] && space[nY][nX]<=size){
                            pq.add(new int[]{nY, nX, nM});
                            visited[nY][nX]=true;
                        }
                    }
                }
            }
            if(!hasPrey){
                break;
            }  
        }
    }
}