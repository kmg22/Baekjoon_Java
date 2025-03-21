import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import org.w3c.dom.Node;

public class Main {
    static ArrayList<Node>[] edges;
    static int[] distance;
    static boolean[] visited;
    static int N,M,K,X;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        edges = new ArrayList[N+1];
        distance = new int[N+1]; // X~i까지의 최단거리
        Arrays.fill(distance, Integer.MAX_VALUE);

        for(int i=0; i<N+1; i++){
            edges[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            edges[A].add(new Node(B, 1));
        }

        bfs();

        boolean sol = false;
        for(int i=0; i<N+1; i++){
            if(distance[i]==K){
                System.out.println(i);
                sol = true;
            }
        }
        if(!sol) System.out.println(-1);
    }

    public static void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(X, 0));
        distance[X] = 0;
        visited = new boolean[N+1];

        while(!q.isEmpty()){
            Node A = q.poll();

            if(visited[A.num]) continue; // 왔던 길 다시 가면 무조건 최단거리는 될 수 없음
            
            visited[A.num] = true;
            for(Node B : edges[A.num]){
                if(!visited[B.num] && distance[B.num]>(distance[A.num]+B.dist)){
                    distance[B.num] = distance[A.num]+B.dist; // X~B 거리 갱신(X~A + A~B)
                    q.add(new Node(B.num, distance[B.num]));
                }
            }

        }
        

    }

    public static class Node{
        int num;
        int dist;

        Node(int num, int dist){
            this.num = num;
            this.dist = dist;
        }

        
    }
}
