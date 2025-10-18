import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[][] fib;
    private static boolean[] check;

    private static int[] Fib(int n){
        if(check[n]){ return fib[n]; }

        for(int i=2; i<=n; i++){
            if(check[i]) { continue; }
            fib[i][0] = fib[i-1][0] + fib[i-2][0];
            fib[i][1] = fib[i-1][1] + fib[i-2][1];
            check[i] = true;
        }
        return fib[n];
    }
    
    public static void main(String[] args) throws Exception{
        int T = Integer.parseInt(br.readLine());
        
        fib = new int[41][2];
        check = new boolean[41];

        fib[0] = new int[] {1, 0};
        fib[1] = new int[] {0, 1}; 
        
        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            int[] result = Fib(N);
            bw.write(result[0] +" "+ result[1] +"\n");
        }
        bw.flush();
        br.close();
        bw.newLine();
    }
}