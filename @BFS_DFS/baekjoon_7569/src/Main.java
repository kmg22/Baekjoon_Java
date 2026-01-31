import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int H, N, M;
    private static int[][][] tomato;
    private static boolean[][][] check;    
    private static int[] dh = {1, -1, 0, 0, 0, 0};
    private static int[] dn = {0, 0, -1, 1, 0, 0};
    private static int[] dm = {0, 0, 0, 0, 1, -1};
    private static Queue<int[]> q = new LinkedList<>();


    private static int BFS(){
        while(!q.isEmpty()){
            int[] tmp = q.poll();

            for(int i=0; i<6; i++){
                int h = tmp[0] + dh[i];
                int n = tmp[1] + dn[i];
                int m = tmp[2] + dm[i];
                if(h>=0 && h<H && n>=0 && n<N && m>=0 && m<M){
                    if(tomato[h][n][m]==0){
                        q.add(new int[]{h, n, m});
                        tomato[h][n][m] = tomato[tmp[0]][tmp[1]][tmp[2]]+1;
                    }
                }
            }
        }
        int result = 0;
        for(int h=0; h<H; h++){
            for(int n=0; n<N; n++){
                for(int m=0; m<M; m++){
                    if(tomato[h][n][m]==0){
                        // 하나라도 안 익은 게 존재하면 -1
                        return -1;
                    }
                    result = Math.max(result, tomato[h][n][m]);
                }
            }
        }

        if(result==1){
            // 처음부터 모두 익어있는 상태
            return 0;
        }else{
            return (result-1);
        }
    }


    public static void main(String[] args) throws Exception {
        String[] input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]); // 상자 가로
        N = Integer.parseInt(input[1]); // 상자 세로
        H = Integer.parseInt(input[2]); // 상자 높이

        tomato = new int[H][N][M];
        check = new boolean[H][N][M];

        int result=-1;

        for(int h=0; h<H; h++){
            for(int n=0; n<N; n++){
                input = br.readLine().split(" ");
                for(int m=0; m<M; m++){
                    tomato[h][n][m] = Integer.parseInt(input[m]);
                    if(tomato[h][n][m]==1){
                        q.add(new int[] {h, n, m});
                    }
                }
            }
        }

        result = BFS();
        bw.write(result+"\n");
        bw.flush();
        
        br.close();
        bw.close();
    }
}
