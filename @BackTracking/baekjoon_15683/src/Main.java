import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, M, result=Integer.MAX_VALUE;
    private static int[][] area;
    private static List<int[]> cctv;
    private static List<boolean[]>[] direction;
    // 위 | 오른쪽 | 아래 | 왼쪽
    private static int[] dy = {-1, 0, 1, 0};
    private static int[] dx = {0, 1, 0, -1};


    public static void main(String[] args) throws Exception {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        boolean[][] isBlind = new boolean[N][M];

        direction = new ArrayList[6];
        for(int i=0; i<=5; i++){
            direction[i] = new ArrayList<>();
        }
        // cctv1 
        direction[1].add(new boolean[]{true,false,false,false});
        direction[1].add(new boolean[]{false,true,false,false});
        direction[1].add(new boolean[]{false,false,true,false});
        direction[1].add(new boolean[]{false,false,false,true});
        // cctv2
        direction[2].add(new boolean[]{true,false,true,false});
        direction[2].add(new boolean[]{false,true,false,true});
        // cctv3
        direction[3].add(new boolean[]{true,true,false,false});
        direction[3].add(new boolean[]{false,true,true,false});
        direction[3].add(new boolean[]{false,false,true,true});
        direction[3].add(new boolean[]{true,false,false,true});
        // cctv4
        direction[4].add(new boolean[]{true,true,true,false});
        direction[4].add(new boolean[]{false,true,true,true});
        direction[4].add(new boolean[]{true,false,true,true});
        direction[4].add(new boolean[]{true,true,false,true});
        // cctv5
        direction[5].add(new boolean[]{true,true,true,true});
        

        area = new int[N][M];
        cctv = new ArrayList<>();
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                area[i][j] = Integer.parseInt(input[j]);
                isBlind[i][j] = area[i][j]==0 ? true : false;

                if(0<area[i][j] && area[i][j]<6){
                    cctv.add(new int[] {i,j, area[i][j]});
                }
            }
        }

        backtracking(0, isBlind);

        bw.write(result+"\n");
        
        bw.flush();
        br.close();
        bw.close();
    }

    private static void backtracking(int idx, boolean[][] isBlind){
        if(idx==cctv.size()){
            int cnt=cntBlind(isBlind);
            result = Math.min(result, cnt);
            return;
        }

        int[] tmpC = cctv.get(idx);
        int type = tmpC[2];

        for(boolean[] check : direction[type]){
            boolean[][] copy = new boolean[N][M];
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    copy[i][j] = isBlind[i][j];
                }
            }

            for(int j=0; j<4; j++){
                if(check[j]){
                    watch(tmpC, copy, j);
                }
            }

            backtracking(idx+1, copy);
        }
    }

    private static void watch(int[] cctv, boolean[][] isBlind, int d){
        int ny = cctv[0] + dy[d];
        int nx = cctv[1] + dx[d];

        while(ny>=0 && ny<N && nx>=0 && nx<M){
            if(area[ny][nx]==6){ break; }
            if(isBlind[ny][nx]){ isBlind[ny][nx]=false; }
            ny += dy[d];
            nx += dx[d];
        }
    }

    private static int cntBlind(boolean[][] isBlind){
        int cnt=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(isBlind[i][j]){ cnt++; }
            }
        }
        return cnt;
    }
}
