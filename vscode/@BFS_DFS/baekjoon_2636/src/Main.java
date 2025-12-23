import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[][] area;
    private static boolean[][] visited;
    private static int N, M;
    private static int[] dn = {-1, 1, 0, 0};
    private static int[] dm = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]); // 가로
        M = Integer.parseInt(input[1]); // 세로
        area = new int[N][M];
        int time=0, last=0;

        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                area[i][j] = Integer.parseInt(input[j]);
                // 치즈 존재 : 1
                // 치즈 존재 x : 0
            }
        }
        last = countCheeze();

        int check = last;
        while(true){
            if(check<1){ break; }
            last = check;

            visited = new boolean[N][M];
            // for(int i=0; i<N; i++){
            //     for(int j=0; j<M; j++){
            //         if(!visited[i][j] && area[i][j]<1){
            //             BFS(i, j);
            //         }
            //     }
            // }
            BFS(0, 0);
            time++;
            check = countCheeze();
        }
        
        bw.write(time + "\n" + last +"\n");
        bw.flush();
        br.close();
        bw.close();
    }

    private static void BFS(int n, int m){
        Queue<int[]> q = new LinkedList<>();
        List<int[]> l = new LinkedList<>();
        q.add(new int[] {n, m});
        visited[n][m] = true;

        while(!q.isEmpty()){
            int[] out = q.poll();

            for(int i=0; i<4; i++){
                int tmpn = out[0] + dn[i];
                int tmpm = out[1] + dm[i];
                if(tmpn>=0 && tmpn<N && tmpm>=0 && tmpm<M){
                    if(!visited[tmpn][tmpm]){
                        if(area[tmpn][tmpm]>0){
                            l.add(new int[] {tmpn, tmpm});
                        }else{
                            q.add(new int[] {tmpn, tmpm});
                        }
                        visited[tmpn][tmpm] = true;
                    }
                }
            }
        }
        for(int[] tmp : l){
            area[tmp[0]][tmp[1]] = 0;
        }
    }

    private static int countCheeze(){
        int cnt=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                cnt += area[i][j];
            }
        }
        return cnt;
    }
}
