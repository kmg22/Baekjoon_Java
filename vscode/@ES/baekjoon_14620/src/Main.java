import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[][] field;
    private static boolean[][] visit;
    private static int[] dx = {0, -1, 1, 0, 0};
    private static int[] dy = {0, 0, 0, -1, 1};
    private static int N, result=Integer.MAX_VALUE;

    private static void DFS(int depth, int cost){
        if(result<=cost){ 
            return;
        }

        if(depth==3){
            result = Math.min(result, cost);
            return;
        }

        for(int i=1; i<N-1; i++){
            for(int j=1; j<N-1; j++){
                boolean flag=true;

                // 현재 위치+상하좌우 검사
                for(int k=0; k<5; k++){
                    int tmpy = i + dy[k];
                    int tmpx = j + dx[k];
                    
                    // 방문기록 있으면 포기
                    if(visit[tmpy][tmpx]){
                        flag=false;
                        break;
                    }
                }
                if(!flag){continue;}

                // 방문처리
                int sum=0;
                for(int k=0; k<5; k++){
                    int tmpy = i + dy[k];
                    int tmpx = j + dx[k];

                    sum += field[tmpy][tmpx];
                    visit[tmpy][tmpx] = true;
                }

                // 깊이 우선 탐색
                DFS(depth+1, cost+sum);

                // 원상복귀(BackTracking)
                for(int k=0; k<5; k++){
                    int tmpy = i + dy[k];
                    int tmpx = j + dx[k];

                    visit[tmpy][tmpx] = false;
                }
            }
        }
        return;
    }
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        field = new int[N][N];

        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                field[i][j] = Integer.parseInt(input[j]);
            }
        }
        visit = new boolean[N][N];
        DFS(0,0);
        bw.write(result+"\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
