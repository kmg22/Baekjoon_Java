import java.util.*;

public class Main {
    static boolean[][] edge;
    static boolean[] check;

    static Queue<Integer> q = new LinkedList<>();

    public static void DFS(int vertex, int N){
        check[vertex] = true;
        System.out.print((vertex+1) + " ");

        for(int i=0; i<N; i++){
            if(edge[vertex][i] && !check[i]){
                DFS(i, N);
            }
        }
    }

    public static void BFS(int vertex, int N){
        check[vertex] = true;
        q.add(vertex);

        while(!q.isEmpty()){
            vertex = q.poll();
            System.out.print((vertex+1) + " ");

            for(int i=0; i<N; i++){
                if(edge[vertex][i] && !check[i]){
                    check[i] = true;
                    q.add(i);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int M = scan.nextInt();
        int V = scan.nextInt();
        edge = new boolean[N][N];

        for(int i=0; i<M; i++){
            int v1 = scan.nextInt()-1;
            int v2 = scan.nextInt()-1;
            edge[v1][v2] = edge[v2][v1] = true;
        }
        
        // DFS
        check = new boolean[N];
        DFS(V-1, N);

        System.out.println();
        
        // BFS
        check = new boolean[N];
        BFS(V-1, N);

        scan.close();
    }
}
