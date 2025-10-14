import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, M;
    private static int[][] map;
    private static int result=0;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0 ,0, -1, 1};

    public static void main(String[] args) throws Exception{
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new int[N][M];
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        BackTracking(0);

        bw.write(result+"\n");
        bw.flush();
        br.close();
        bw.close();
    }

    private static void BackTracking(int cnt){
        if(cnt==3){
            result = Math.max(result, getSafeArea(BFS()));
            return;
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]==0){
                    map[i][j]=1;
                    BackTracking(cnt+1);
                    map[i][j]=0;
                }
            }
        }
    }

    private static int[][] BFS(){
        Queue<int[]> q = new LinkedList<>();

        // 원본 map 복사
        int[][] tmpMap = new int[N][M];
        for(int i=0; i<N; i++){
            tmpMap[i] = map[i].clone();
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(tmpMap[i][j]==2){
                    q.offer(new int[]{i, j});
                }
            }
        }

        while(!q.isEmpty()){
            int[] tmp = q.poll();

            for(int i=0; i<4; i++){
                int tmpx = tmp[0] + dx[i];
                int tmpy = tmp[1] + dy[i];

                if(tmpx>=0 && tmpx<N && tmpy>=0 && tmpy<M){
                    if(tmpMap[tmpx][tmpy]==0){
                        tmpMap[tmpx][tmpy]=2;
                        q.offer(new int[]{tmpx, tmpy});
                    }
                }
            }
        }

        return tmpMap;
    }

    private static int getSafeArea(int[][] tmpMap){
        int safeArea=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(tmpMap[i][j]==0){
                    safeArea++;
                }
            }
        }
        return safeArea;
    }

}