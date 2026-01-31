import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static int[][] area;
    private static int N, L, R;
    private static boolean isMove;
    private static boolean[][] visited;

    private static void BFS(int r, int c){
        Queue<int[]> q = new LinkedList<>();
        LinkedList<int[]> list = new LinkedList<>();
        q.add(new int[] {r, c});
        list.add(new int[] {r, c});
        visited[r][c] = true;
        int sum=area[r][c];

        while(!q.isEmpty()){
            int[] out = q.poll();
            int br = out[0]; // base 기준 정보
            int bc = out[1];

            for(int i=0; i<4; i++){
                int nr = br + dr[i]; // near 인접 정보
                int nc = bc + dc[i];
                
                if(nr>=0 && nr<N && nc>=0 && nc<N){
                    if(!visited[nr][nc]){
                        int diff = Math.abs(area[br][bc]-area[nr][nc]);
                        if(L<=diff && diff<=R){
                            q.add(new int[] {nr, nc});
                            list.add(new int[] {nr, nc});
                            sum += area[nr][nc];
                            visited[nr][nc] = true;
                        }

                    }
                }
            }
        }

        if(list.size()>1){
            int avg = sum / list.size();
            isMove = true;
            for(int[] tmp : list){
                area[tmp[0]][tmp[1]] = avg;
            }
        }
        
    }
    public static void main(String[] args) throws Exception {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]); // N x N 크기 땅
        L = Integer.parseInt(input[1]);
        R = Integer.parseInt(input[2]);
        int result=0;
        area = new int[N][N];


        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                area[i][j] = Integer.parseInt(input[j]);
            }
        }

        while(true){
            isMove = false;
            visited = new boolean[N][N];

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!visited[i][j]){
                        BFS(i,j);
                    }
                }
            }
            if(!isMove) break;
            result++;
        }

        bw.write(result+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
