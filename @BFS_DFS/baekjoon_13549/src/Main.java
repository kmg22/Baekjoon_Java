import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static final int MAX=100000;
    static int sol = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        visited = new boolean[MAX+1];
        
        bfs(N,K);
        System.out.println(sol);
    }

    public static void bfs(int N, int K){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(N, 0));

        while(!q.isEmpty()){
            Node node = q.poll();
            visited[node.x] = true;

            // 목적지 도달
            if(node.x == K){
                sol = Math.min(sol, node.time);
            }

            // 계산
            int tmp = node.x*2;
            if(tmp<=MAX && !visited[tmp]){
                q.add(new Node(tmp, node.time));
            }

            tmp = node.x+1;
            if(tmp<=MAX && !visited[tmp]){
                q.add(new Node(tmp, node.time+1));
            }

            tmp = node.x-1;
            if(tmp>=0 && !visited[tmp]){
                q.add(new Node(tmp, node.time+1));
            }
            
        }
    }

    public static class Node{
        int x;
        int time;

        public Node(int x, int time){
            this.x = x;
            this.time = time;
        }
    }
}
