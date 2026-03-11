import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static String[] input;
    private static int N, M, d, r, c, result;
    private static int[][] room; // 0:dirty | 1:wall | 2:clean
    private static int[] dr = {-1, 0, 1, 0}; // n | e | s | w
    private static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        room = new int[N][M];

        // robot start position
        input = br.readLine().split(" ");
        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        d = Integer.parseInt(input[2]);

        // room condition
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                room[i][j] = Integer.parseInt(input[j]);
            }
        }

        while(true){
            if(r<1 || r>=N || c<1 || c>=M || room[r][c]==1) break;

            // clean the space
            if(room[r][c]==0){
                result++;
                room[r][c]=2;
            }

            boolean flag=false;
            for(int k=0; k<4; k++){
                d = (d+3)%4;
                int tmpr = r + dr[d];
                int tmpc = c + dc[d];

                // yes dirty space
                if(room[tmpr][tmpc]==0){
                    flag=true;
                    r=tmpr; c=tmpc;
                    break;
                }
            }
            if(flag) continue;

            // no dirty space
            int tmpd = (d+2)%4;
            r += dr[tmpd];
            c += dc[tmpd];

        }
        bw.write(result+"\n");
        
        bw.flush();
        br.close();
        bw.close();
    }
}
