import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static char[][] table;
    private static boolean[] idxVisited;
    private static int result;

    public static void main(String[] args) throws Exception{
        table = new char[5][5];
        idxVisited = new boolean[25];

        String input;
        for(int i=0; i<5; i++){
            input = br.readLine();
            for(int j=0; j<5; j++){
                table[i][j] = input.charAt(j); // Y or S
            }
        }

        search(0, 0, 0);
        bw.write(result+"\n");
        bw.flush();
        br.close();
        bw.close();
    }

    private static void search(int idx, int combi, int yCnt){
        // Y가 4명 이상
        if(yCnt>=4){ return; }

        // 조합 완성
        if(combi==7){
            int curIdx = idx-1;
            int curY = curIdx / 5;
            int curX = curIdx % 5;
            if(BFS(curY, curX)){ result++; }
            return;
        }

        // 조합 구성
        for(int i=idx; i<25; i++){
            int tmpY = i / 5;
            int tmpX = i % 5;

            idxVisited[i] = true;
            if(table[tmpY][tmpX] == 'Y'){
                search(i+1, combi+1, yCnt+1);
            }else{
                search(i+1, combi+1, yCnt);
            }
            idxVisited[i] = false;
        }
    }

    private static boolean BFS(int Y, int X){
        boolean[][] visited = new boolean[5][5];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {Y, X});
        visited[Y][X] = true;

        int cnt=1;
        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i=0; i<4; i++){
                int ny = cur[0]+dy[i];
                int nx = cur[1]+dx[i];
                int nidx = ny*5 + nx;
                if(ny>=0 && ny<5 && nx>=0 && nx<5){
                    if(!visited[ny][nx] && idxVisited[nidx]){
                        visited[ny][nx] = true;
                        q.add(new int[] {ny, nx});
                        cnt++;
                    }
                }
            }
        }
        
        return cnt==7;
    }
}