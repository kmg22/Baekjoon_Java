/*
 * DFS
 */
import java.io.*;
import java.util.*;

public class DFS{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, M, target1, target2;
    static boolean[][] family;
    static int[] distance;

    public static void DFS(int idx){
        if(idx == target2){
            return;
        }

        for(int i=1; i<=N; i++){
            if(family[idx][i] && distance[i]==0){
                distance[i] = distance[idx]+1;
                DFS(i);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine()); // 전체 사람 수
        distance = new int[N+1];
        family = new boolean[N+1][N+1];

        String[] input = br.readLine().split(" ");
        int target1 = Integer.parseInt(input[0]);
        int target2 = Integer.parseInt(input[1]);
        
        M = Integer.parseInt(br.readLine()); // 관계 수
        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            family[x][y] = family[y][x] = true;
        }

        DFS(target1);
        int result = distance[target2]==0 ? -1 : distance[target2];
        bw.write(result +"\n");

        bw.flush();
        br.close();
        bw.close();
    }
}