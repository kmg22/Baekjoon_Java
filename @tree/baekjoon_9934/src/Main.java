import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int K, N, I;
    private static String[] input;
    private static int[] tree;

    public static void main(String[] args) throws Exception {
        K = Integer.parseInt(br.readLine());
        N = (int)Math.pow(2, K)-1;
        tree = new int[N+1];

        input = br.readLine().split(" ");
        order(1);

        for(int i=0; i<K; i++){
            int start = (int)Math.pow(2, i);
            int end = (int)Math.pow(2, i+1);
            for(int j=start; j<end; j++){
                bw.write(tree[j]+" ");
            }
            bw.newLine();
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static void order(int idx){
        if(idx>N) return;

        order(idx*2);
        tree[idx] = Integer.parseInt(input[I++]);
        order(idx*2+1);
    }
}
