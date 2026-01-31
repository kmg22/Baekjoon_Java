import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[][] iceberg;
    private static boolean[][] visited;
    private static Queue<int[]> meltArea;
    private static int N, M;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args)throws Exception{
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]); // 행
        M = Integer.parseInt(input[1]); // 열
        iceberg = new int[N][M];
        int result=0;

        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                iceberg[i][j] = Integer.parseInt(input[j]);
            }
        }

        while(true){
            visited = new boolean[N][M];
            meltArea = new LinkedList<>();

            int cnt=0;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(iceberg[i][j]>0 && !visited[i][j]){
                        BFS(i, j);
                        cnt++;
                    }
                }
            }

            // break 조건
            if(cnt>=2){
                bw.write(result+"\n");
                break;
            }
            if(cnt<=0){
                bw.write("0\n");
                break;
            }

            // 영토 한 번에 녹이기
            while(!meltArea.isEmpty()){
                int[] melt = meltArea.poll();
                int meltN = melt[0];
                int meltM = melt[1];
                if(iceberg[meltN][meltM]>0){
                    iceberg[meltN][meltM]--;
                }
            }
            
            result++;
        }
        
        bw.flush();
        br.close();
        bw.close();
    }

    private static void BFS(int n, int m){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{n, m});
        visited[n][m] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curN = cur[0];
            int curM = cur[1];

            for(int i=0; i<4; i++){
                int tmpN = curN+dy[i];
                int tmpM = curM+dx[i];
                // 주변이 바다
                if(iceberg[tmpN][tmpM]==0 && iceberg[curN][curM]>0){
                    meltArea.add(new int[] {curN, curM});
                }
                // 주변이 영토
                if(iceberg[tmpN][tmpM]>0 && !visited[tmpN][tmpM]){
                    q.add(new int[] {tmpN, tmpM});
                    visited[tmpN][tmpM] = true;
                }
            }
        }
    }
}