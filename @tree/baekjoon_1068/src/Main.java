import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, X;
    private static int[] parent;
    private static boolean[] check;
    
    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        parent = new int[N];
        check = new boolean[N];
        Arrays.fill(check, true);

        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            parent[i] = Integer.parseInt(input[i]);
        }

        X = Integer.parseInt(br.readLine());
        delete(X);

        int result=0;
        for(int i=0; i<N; i++){
            if(isleaf(i)) result++;
        }

        bw.write(result+"\n");

        bw.flush();
        br.close();
        bw.close();
    }

    static void delete(int X){
        check[X] = false;
        for(int i=0; i<N; i++){
            if(check[i] && parent[i]==X){
                delete(i);
            }
        }
    }

    static boolean isleaf(int X){
        if(!check[X]) return false;

        for(int i=0; i<N; i++){
            if(check[i] && parent[i]==X){
                return false;
            }
        }
        return true;
    }
}