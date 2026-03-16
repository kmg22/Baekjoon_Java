import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, M, x, y, K;
    private static int dir, r, c;
    private static int[][] map;
    private static int[][] dice = new int[2][4]; // <동서/북남> 주사위 구분
    private static int[] idx = new int[2];
    private static int[] dr = {0, 0, 0, -1, 1}; // - | 동 | 서 | 북 | 남
    private static int[] dc = {0, 1, -1, 0, 0};


    public static void main(String[] args) throws Exception {
        String[] input = br.readLine().split(" ");
        // map size
        N = Integer.parseInt(input[0]); // 세로
        M = Integer.parseInt(input[1]); // 가로
        // dice start position
        x = Integer.parseInt(input[2]);
        y = Integer.parseInt(input[3]);
        // commend count
        K = Integer.parseInt(input[4]);

        map = new int[N][M];
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        } 

        input = br.readLine().split(" ");
        for(int i=0; i<K; i++){
            dir = Integer.parseInt(input[i]);
            r = x + dr[dir];
            c = y + dc[dir];
            
            if(r<0 || r>=N || c<0 || c>=M){ continue; }

            x += dr[dir];
            y += dc[dir];

            switch(dir){
                // 동-서 이동
                case 1:
                    dice[1][idx[1]] = roll(0, 1);
                    break;
                case 2:
                    dice[1][idx[1]] = roll( 0, 3);
                    break;
                // 북-남 이동
                case 3:
                    dice[0][idx[0]] = roll(1, 3);
                    break;
                case 4:
                    dice[0][idx[0]] = roll(1, 1);
                    break;
            }
            
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static int roll(int i, int dir) throws Exception{
        idx[i] = (idx[i]+dir)%4;

        if(map[x][y]>0){
            dice[i][idx[i]] = map[x][y];
            map[x][y] = 0;
        }else{
            map[x][y] = dice[i][idx[i]];
        }

        // 중복되는 부분 숫자 동기화
        int tmp = (idx[i]+2)%4;
        int rev = i==0?1:0;
        int tmpi = (idx[rev]+2)%4;
        dice[rev][tmpi] = dice[i][tmp];
        bw.write(dice[i][tmp]+"\n");

        // 겹치는 바닥면 숫자 갱신
        return dice[i][idx[i]];
    }
}

/*
0 2
3 4
5 6
7 8
*/



