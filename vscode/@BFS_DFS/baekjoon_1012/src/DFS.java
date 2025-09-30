/*
 * DFS ... 재귀
 */

import java.io.*;
import java.util.*;

public class DFS {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int W, H, K;
    private static boolean[][] visit;
    private static int[][] field;
    static int[] dx = {0, -1, 0, 1}; // 오|왼|아|위
    static int[] dy = {1, 0, -1, 0};

    public static void DFS(int x, int y){
        visit[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<W  &&  ny>=0 && ny<H){
                if(field[nx][ny]==1 && !visit[nx][ny]){
                    DFS(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        int T = Integer.parseInt(br.readLine());
        
        for(int t=0; t<T; t++){
            String[] input = br.readLine().split(" ");
            W = Integer.parseInt(input[0]); // 배추 밭 가로
            H = Integer.parseInt(input[1]); // 배추 밭 세로
            K = Integer.parseInt(input[2]); // 배추 개수

            field = new int[W][H]; // 좌표 별 배추 여부
            visit = new boolean[W][H]; // 방문 여부
            for(int k=0; k<K; k++){
                input = br.readLine().split(" ");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);
                field[x][y] = 1;
            }

            int cnt=0;
            for(int w=0; w<W; w++){
                for(int h=0; h<H; h++){
                    if(field[w][h]==1 && !visit[w][h]){
                        DFS(w, h);
                        cnt++;
                    }
                }
            }
            bw.write(cnt+"\n");
        }
        
        bw.flush();
        br.close();
        bw.close();   
    }
}
