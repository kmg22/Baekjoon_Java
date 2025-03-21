import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static ArrayList<Node>[] edges;
    private static int[] distance;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        distance = new int[D+1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        edges = new ArrayList[D+1];
        for(int i=0; i<D; i++){
            edges[i] = new ArrayList<>();
            edges[i].add(new Node(i+1, 1));
        }
        edges[D] = new ArrayList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            
            if(a<=D && b<=D) edges[a].add(new Node(b, d));
        }
        bfs(D);
        System.out.println(distance[D]);
    }
    
    public static void bfs(int D){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,0));
        distance[0] = 0;
        // boolean[] visited = new boolean[D+1];

        while(!q.isEmpty()){
            Node A = q.poll();
            
            // visited[A.n] = true;

            for(Node B : edges[A.n]){
                if(distance[B.n]>distance[A.n]+B.dist){
                    distance[B.n] = distance[A.n]+B.dist;
                    q.add(new Node(B.n, distance[B.n]));
                }
            }
        }
    }

    public static class Node{
        int n;
        int dist;

        Node(int n, int dist){
            this.n = n;
            this.dist = dist;
        }
    }
}
