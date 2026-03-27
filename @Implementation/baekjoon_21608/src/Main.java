import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, NN, x;
    private static int[][] room;
    private static boolean[][] filled;
    private static String[] input;
    private static HashSet<Integer>[] like;
    private static PriorityQueue<int[]> pq;
    private static int[] dr = {-1, 1, 0, 0}; // 상 | 하 | 좌 | 우
    private static int[] dc = {0, 0, -1, 1}; 

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        NN = N*N;

        room = new int[N][N];
        filled = new boolean[N][N];
        like = new HashSet[NN+1];
        for(int i=1; i<=NN; i++){ like[i] = new HashSet<>(); }
        pq = new PriorityQueue<>(new Comparator<int[]>(){
                @Override
                public int compare(int[] o1, int[] o2){
                    if(o1[2]!=o2[2]) return o2[2]-o1[2];
                    if(o1[3]!=o2[3]) return o2[3]-o1[3];
                    if(o1[0]!=o2[0]) return o1[0]-o2[0];
                    return o1[1]-o2[1];
                }
            });

        for(int i=0; i<NN; i++){
            input = br.readLine().split(" ");
            x = Integer.parseInt(input[0]);
            for(int j=1; j<=4; j++){
                like[x].add(Integer.parseInt(input[j]));
            }
            calc();
            int[] out = pq.poll();
            room[out[0]][out[1]] = x;
            filled[out[0]][out[1]] = true;

            pq.clear();
        }

        int result=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                int satis=0;
                for(int k=0; k<4; k++){
                    int tmpr = i + dr[k];
                    int tmpc = j + dc[k];
                    if(tmpr<0 || tmpr>=N || tmpc<0 || tmpc>=N){ continue; }
                    if(like[room[i][j]].contains(room[tmpr][tmpc])){ satis++; }
                }
                switch(satis){
                    case 0: break;
                    case 1: result+=1; break;
                    case 2: result+=10; break;
                    case 3: result+=100; break;
                    case 4: result+=1000; break;
                }
            }
        }
        bw.write(result+"\n");
        bw.flush();
        br.close();
        bw.close();
    }

    private static void calc(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!filled[i][j]){ 
                    near(i, j);
                }
            }
        }
    }

    private static void near(int r, int c){
        int likeCnt=0, emptyCnt=0;
        for(int i=0; i<4; i++){
            int tmpr = r + dr[i];
            int tmpc = c + dc[i];
            if(tmpr<0 || tmpr>=N || tmpc<0 || tmpc>=N){ continue; }
            if(like[x].contains(room[tmpr][tmpc])){ likeCnt++; }
            if(!filled[tmpr][tmpc]){ emptyCnt++;}
        }
        pq.add(new int[] {r, c, likeCnt, emptyCnt} );
    }
}
