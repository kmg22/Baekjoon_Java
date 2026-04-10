import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, M;
    private static String[] input;
    private static int[] parent;
    
    public static void main(String[] args) throws Exception {
        input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        parent = new int[N+1];
        for(int i=0; i<=N; i++){
            parent[i] = i;
        }
        
        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");
            int op = Integer.parseInt(input[0]);
            int a = Integer.parseInt(input[1]);
            int b = Integer.parseInt(input[2]);
            switch(op){
                case 0:
                    union(a, b);
                    break;
                case 1:
                    String result = check(a, b) ? "YES\n" : "NO\n";
                    bw.write(result);
                    break;
            }
        }

        
        bw.flush();
        br.close();
        bw.close();
    }

    private static void union(int a, int b){
        int roota = find(a);
        int rootb = find(b);
        if(roota!=rootb){
            parent[roota] = rootb; // 루트끼리 연결
        }
    }

    private static boolean check(int a, int b){
        int roota = find(a);
        int rootb = find(b);
        if(roota==rootb){ return true; }
        return false;
    }

    private static int find(int e){
        if(parent[e]==e){ return e; }
        return parent[e] = find(parent[e]); // 부모 값을 루트 노드로 갱신(경로 압축)
    }
}
