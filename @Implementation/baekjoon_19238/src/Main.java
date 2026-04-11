import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, M, O, INF=1_000_000_000, solveCnt=0;
    private static int myR, myC;
    private static int[][] map;
    private static boolean[] solve;
    private static List<int[]> guest = new ArrayList<>();
    private static int[] dr = {-1, 0, 0, 1};
    private static int[] dc = {0, -1, 1, 0};

    
    public static void main(String[] args) throws Exception {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        O = Integer.parseInt(input[2]);

        map = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            input = br.readLine().split(" ");
            for(int j=1; j<=N; j++){
                map[i][j] = Integer.parseInt(input[j-1]);
            }
        }

        // taxi position
        input = br.readLine().split(" ");
        myR = Integer.parseInt(input[0]);
        myC = Integer.parseInt(input[1]);
        
        // guest start-end position + dist
        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");
            int startR = Integer.parseInt(input[0]);
            int startC = Integer.parseInt(input[1]);
            int endR = Integer.parseInt(input[2]);
            int endC = Integer.parseInt(input[3]);
            int dist = search(startR, startC, endR, endC);
            guest.add(new int[] {startR, startC, endR, endC, dist});
        }
        // sort guests by row, col
        guest.sort((a,b)-> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);

        solve = new boolean[M];
        solveCnt = 0;

        while(solveCnt<M){
            int[][] distMap = getDistMap(myR, myC); // bfs를 한 번만 호출해야 시간 초과 발생 x

            // find next guest
            int nextI=-1, nextD=INF;
            for(int i=0; i<M; i++){
                if(solve[i]) continue;
                int tmpR = guest.get(i)[0];
                int tmpC = guest.get(i)[1];
                int tmpD = distMap[tmpR][tmpC];
                if(nextD>tmpD){
                    nextI = i;
                    nextD = tmpD;
                }
            }

            // go to guest
            O -= nextD;
            if(O<0){break;}

            // go to destination
            O -= guest.get(nextI)[4];
            if(O<0){break;}

            O += guest.get(nextI)[4]*2;
            myR = guest.get(nextI)[2];
            myC = guest.get(nextI)[3];

            solve[nextI] = true;
            solveCnt++;
        }
        
        int result=-1;
        if(O>=0){ result = O;}
        bw.write(result+"\n");
        bw.flush();
        br.close();
        bw.close();
    }

    // calc guest-destination distance
    private static int search(int startR, int startC, int endR, int endC){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {startR, startC, 0});
        boolean[][] visited = new boolean[N+1][N+1];
        visited[startR][startC] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[0]==endR && cur[1]==endC){ return cur[2]; }

            for(int i=0; i<4; i++){
                int nextR = cur[0] + dr[i];
                int nextC = cur[1] + dc[i];
                if(nextR<1 || nextR>N || nextC<1 || nextC>N ){ continue; }
                if(map[nextR][nextC]==1 || visited[nextR][nextC]){ continue; }
                q.add(new int[] {nextR, nextC, cur[2]+1});
                visited[nextR][nextC] = true;
            }
        }
        return INF;
    }

    private static int[][] getDistMap(int r, int c){
        int[][] dists = new int[N+1][N+1];
        for(int i=1; i<=N; i++) Arrays.fill(dists[i], INF);
        boolean[][] visited = new boolean[N+1][N+1];
        
        Queue<int[]> q= new LinkedList<>();
        q.add(new int[] {r, c});
        dists[r][c] = 0;
        visited[r][c] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int i=0; i<4; i++){
                int nextR = cur[0] + dr[i];
                int nextC = cur[1] + dc[i];
                if(nextR<1 || nextR>N || nextC<1 || nextC>N ){ continue; }
                if(map[nextR][nextC]==1 || visited[nextR][nextC]){ continue; }
                dists[nextR][nextC] = dists[cur[0]][cur[1]]+1;
                q.add(new int[] {nextR, nextC});
                visited[nextR][nextC] = true;
            }
        }
        return dists;
    }
}
