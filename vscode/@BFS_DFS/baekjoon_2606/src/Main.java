import java.util.Scanner;

public class Main {
    static boolean[][] net;
    static boolean[] check;
    static int out;

    public static void DFS(int vertex, int N){
        check[vertex] = true;
        out++;
        
        for(int i=1; i<N; i++){
            if(net[vertex][i] && !check[i]){
                DFS(i, N);
            }
        }
        
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        int pc_count = scan.nextInt() + 1;
        int net_count = scan.nextInt();
        net = new boolean[pc_count][pc_count];

        for(int i=0; i<net_count; i++){
            int v1 = scan.nextInt();
            int v2 = scan.nextInt();
            net[v1][v2] = net[v2][v1] = true;
        }

        // DFS
        out = -1;
        check = new boolean[pc_count];
        DFS(1, pc_count);
        System.out.println(out);
    }
}
