/*
 * BFS
 */
import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, M;
    private static int[][] family;
    private static boolean[] visit;

    public static int BFS(int target1, int target2){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{target1, 0}); // person - target1과의 촌수
        visit[target1] = true;

        while(!q.isEmpty()){
            int[] person = q.poll();
            if(person[0]==target2){
                return person[1];
            }

            for(int i=0; i<M; i++){
                if(family[i][0]==person[0] && !visit[family[i][1]]){ // person이 부모에 해당
                    q.offer(new int[] {family[i][1], person[1]+1});
                    visit[person[0]] = true;
                }
                if(family[i][1]==person[0] && !visit[family[i][0]]){ // person이 자식에 해당
                    q.offer(new int[] {family[i][0], person[1]+1});
                    visit[person[0]] = true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine()); // 전체 사람 수
        visit = new boolean[N+1];

        String[] input = br.readLine().split(" ");
        int target1 = Integer.parseInt(input[0]);
        int target2 = Integer.parseInt(input[1]);
        
        M = Integer.parseInt(br.readLine()); // 관계 수
        family = new int[M][2]; // parent-child
        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");
            family[i][0] = Integer.parseInt(input[0]);
            family[i][1] = Integer.parseInt(input[1]);
        }

        int result = BFS(target1, target2);
        bw.write(result+"\n");

        bw.flush();
        br.close();
        bw.close();
    }
}