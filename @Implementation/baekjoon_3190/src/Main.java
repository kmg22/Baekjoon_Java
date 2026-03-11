import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, K, L, r, c, X, way, result;
    private static char C;
    private static String[] input;
    private static boolean[][] apple, snake;
    private static boolean flag;
    private static Deque<int[]> dq = new LinkedList<>();
    private static int[] dr = {-1, 0, 1, 0}; // 남 | 동 | 북 | 서
    private static int[] dc = {0, 1, 0, -1}; 

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine()); // 보드 : NxN
        K = Integer.parseInt(br.readLine()); // 사과 개수
        apple = new boolean[N+1][N+1];
        snake = new boolean[N+1][N+1];

        for(int i=0; i<K; i++){
            input = br.readLine().split(" ");
            r = Integer.parseInt(input[0]);
            c = Integer.parseInt(input[1]);
            apple[r][c] = true;
        }
        dq.add(new int[] {1, 1});
        way = 1; // 초기 방향 : 동(1)
        snake[1][1] = true;
        result=1;
        
        L = Integer.parseInt(br.readLine()); // 방향 전환 횟수
        for(int i=0; i<L; i++){
            input = br.readLine().split(" ");
            X = Integer.parseInt(input[0]);
            C = input[1].charAt(0);
                
            for(;result<=X; result++){
                flag = go();
                if(flag) break;
            }
            if(flag) break;
            way = C=='L' ? (way+3)%4 : (way+1)%4;
        }

        while(!flag){
            flag = go();
            if(!flag) result++;
        }

        bw.write(result+"\n");
        
        bw.flush();
        br.close();
        bw.close();
    }

    private static boolean go() throws Exception{
        int[] head = dq.peekLast();
        int headr = head[0] + dr[way];
        int headc = head[1] + dc[way];

        // 범위 초과 or 부딪힘
        if(headr<1 || headc<1 || headr>N || headc>N || snake[headr][headc]){
            return true;
        }

        dq.addLast(new int[] {headr, headc});
        snake[headr][headc] = true;

        // 사과 여부
        if(!apple[headr][headc]){
            int[] tail = dq.pollFirst();
            snake[tail[0]][tail[1]] = false;
        }else{
            apple[headr][headc] = false;
        }

        return false;
    }
}


/*
_ _ _ _ _ _
_ _ _ _ _ .
_ _ _ . _ _
_ _ _ _ _ _
_ _ . _ _ _
_ _ _ _ _ _ 

 */
