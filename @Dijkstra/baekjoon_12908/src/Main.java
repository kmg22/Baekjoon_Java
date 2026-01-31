import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Node>[][] edges;
    private static int[][] distance;
    static int SIZE=1_000_000_001;
    static int xs, ys, xe, ye;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

        StringTokenizer st = new StringTokenizer(br.readLine());
        xs = Integer.parseInt(st.nextToken());
        ys = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        xe = Integer.parseInt(st.nextToken());
        ye = Integer.parseInt(st.nextToken());

        edges = new ArrayList[SIZE][SIZE];
        distance = new int[SIZE][SIZE];
        for(int x=0; x<SIZE; x++){
            for(int y=0; y<SIZE; y++){
                distance[x][y] = Integer.MAX_VALUE;

                edges[x][y] = new ArrayList<>();
                edges[x][y].add(new Node(x+1, y, 1));
                edges[x][y].add(new Node(x-1, y, 1));
                edges[x][y].add(new Node(x, y+1, 1));
                edges[x][y].add(new Node(x, y-1, 1));
            }
        }
        edges[SIZE][SIZE] = new ArrayList<>();
        edges[SIZE][SIZE-1] = new ArrayList<>();
        edges[SIZE-1][SIZE] = new ArrayList<>();
        
        for(int i=0; i<3; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            edges[x1][y1].add(new Node(x2, y2, 10));
        }

        bfs();

    }

    public static void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(xs, ys, 0));

        distance[xs][ys] = 0;
        //boolean[][] visited = new boolean[SIZE][SIZE];

        while(!q.isEmpty()){
            Node A = q.poll();
            if(xs==xe && ys==ye) break;
            //visited[xs][ys] = true;

            for(Node B : edges[A.x][A.y]){
                if(distance[B.x][B.y]>distance[A.x][A.y]+B.dist){
                    distance[B.x][B.y] = distance[A.x][A.y]+B.dist;
                    q.add(new Node(B.x, B.y, distance[B.x][B.y]));
                }
            }
        }
    }

    public static class Node{
        int x;
        int y;
        int dist;

        Node(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
