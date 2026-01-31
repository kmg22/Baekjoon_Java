import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    private static int N;
    private static ArrayList<Integer>[] tree;
    private static boolean[] hasParent;    
    private static int[] parent;

    private static void BFS(int x){
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        hasParent[x] = true;

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i : tree[cur]){
                if(!hasParent[i]){
                    q.offer(i);
                    hasParent[i] = true;
                    parent[i] = cur;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine()); // 노드 개수
        
        tree = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            tree[i] = new ArrayList<>();
        }
        hasParent = new boolean[N+1];
        parent = new int[N+1];

        for(int i=1; i<N; i++){
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            tree[x].add(y);
            tree[y].add(x);
        }

        BFS(1);   
        for(int i=2; i<=N; i++){
            bw.write(parent[i]+"\n");
        }
        
        // 메모리 사용량 확인
        // Runtime.getRuntime().gc();
        // long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        // bw.write(usedMemory + " bytes");

        bw.flush();
        br.close();
        bw.close();
    }
}