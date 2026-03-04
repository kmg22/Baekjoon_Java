import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, M, test=1;
    private static boolean[] visited;
    private static ArrayList<Integer>[] edges;

    public static void main(String[] args) throws Exception {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        while(!(N==0 && M==0)){
            int T=0;
            visited = new boolean[N+1];

            // 간선 초기화
            edges = new ArrayList[N+1];
            for(int i=1; i<=N; i++){
                edges[i] = new ArrayList<>();
            }

            for(int i=0; i<M; i++){
                input = br.readLine().split(" ");
                int n1 = Integer.parseInt(input[0]);
                int n2 = Integer.parseInt(input[1]);
                edges[n1].add(n2);
                edges[n2].add(n1);
            }

            for(int i=1; i<=N; i++){
                if(!visited[i]){
                    visited[i] = true;
                    boolean flag = travel(i, 0);
                    if(flag) T++;
                }
            }

            switch(T){
                case 0 :
                    bw.write("Case "+ test++ +": No trees.\n");
                    break;
                case 1 :
                    bw.write("Case "+ test++ +": There is one tree.\n");
                    break;
                default :
                    bw.write("Case "+ test++ +": A forest of "+T+" trees.\n");
            }


            input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            M = Integer.parseInt(input[1]);
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static boolean travel(int idx, int parent){
        boolean flag = true;
        for(int next : edges[idx]){
            if(!visited[next]){
                visited[next] = true;
                if(!travel(next, idx)) flag = false; // 서브트리에서 사이클 발생해도 트리 x
            }else{
                // 사이클 발생 => 트리 x
                if(next != parent) flag = false;
            }
        }
        return flag;
    }
}
