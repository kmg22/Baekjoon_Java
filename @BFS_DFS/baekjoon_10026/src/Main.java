import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N;
    private static char[][] picture;
    private static boolean[][] visit;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static void BFS(int y, int x, int type){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});
        visit[y][x] = true;
        
        while(!q.isEmpty()){
            int[] out = q.poll();
            int outy = out[0];
            int outx = out[1];
            
            for(int i=0; i<4; i++){
                int tmpy = outy + dy[i];
                int tmpx = outx + dx[i];
                
                if(tmpy>=0 && tmpy<N && tmpx>=0 && tmpx<N){
                    switch(type){
                        case 0:
                            if(picture[outy][outx]==picture[tmpy][tmpx] && !visit[tmpy][tmpx]){
                                q.add(new int[] {tmpy, tmpx});
                                visit[tmpy][tmpx] = true;
                            }
                            break;
                        default:
                            if((picture[outy][outx]==picture[tmpy][tmpx] || (picture[outy][outx]!='B' && picture[tmpy][tmpx]!='B')) && !visit[tmpy][tmpx]){
                                q.add(new int[] {tmpy, tmpx});
                                visit[tmpy][tmpx] = true;
                            }
                            break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        String input;
        int cnt;
        picture = new char[N][N];

        for(int i=0; i<N; i++){
            input = br.readLine();
            for(int j=0; j<N; j++){
                picture[i][j] = input.charAt(j);
            }
        }

        // 적록색약 X
        visit = new boolean[N][N];
        cnt=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visit[i][j]){
                    BFS(i, j, 0);
                    cnt++;
                }
            }
        }
        bw.write(cnt+" ");

        // 적록색약 O
        visit = new boolean[N][N];
        cnt=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visit[i][j]){
                    BFS(i, j, 1);
                    cnt++;
                }
            }
        }
        bw.write(cnt+"\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
