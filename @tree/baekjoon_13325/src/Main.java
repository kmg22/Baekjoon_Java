import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int K, N, L, result;
    private static int[] tree;

    public static void main(String[] args) throws Exception {
        K = Integer.parseInt(br.readLine());
        N = (int)Math.pow(2, K+1)-1; // 전체 노드 수
        L = (int)Math.pow(2, K); // leaf 시작 인덱스
        tree = new int[N+2];

        String[] input = br.readLine().split(" ");
        for(int i=2; i<=N; i++){
            tree[i] = Integer.parseInt(input[i-2]);
        }

        DFS(1);
        bw.write(result+"\n");

        bw.flush();
        br.close();
        bw.close();
    }

    private static int DFS(int idx){
        if(idx>=L){
            result += tree[idx];
            return tree[idx];
        }

        int left = DFS(idx*2);
        int right = DFS(idx*2+1);

        result += tree[idx] + Math.abs(left-right);
        return tree[idx] + Math.max(left, right);
    }
}
