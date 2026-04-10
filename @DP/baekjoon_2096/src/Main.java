import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, Min=Integer.MAX_VALUE, Max=0;
    private static String[] input;

    private static int[][] MaxDp, MinDp;
    
    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        
        MaxDp = new int[N+1][3];
        MinDp = new int[N+1][3];

        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            int n0 = Integer.parseInt(input[0]);
            int n1 = Integer.parseInt(input[1]);
            int n2 = Integer.parseInt(input[2]);

            if(i==0){
                MaxDp[0][0] = MinDp[0][0] = n0;
                MaxDp[0][1] = MinDp[0][1] = n1;
                MaxDp[0][2] = MinDp[0][2] = n2;
                continue;
            }

            // Max
            MaxDp[i][0] = Math.max(MaxDp[i-1][0], MaxDp[i-1][1])+n0;
            MaxDp[i][1] = Math.max(MaxDp[i-1][0], Math.max(MaxDp[i-1][1], MaxDp[i-1][2]))+n1;
            MaxDp[i][2] = Math.max(MaxDp[i-1][1], MaxDp[i-1][2])+n2;
            
            // Min
            MinDp[i][0] = Math.min(MinDp[i-1][0], MinDp[i-1][1])+n0;
            MinDp[i][1] = Math.min(MinDp[i-1][0], Math.min(MinDp[i-1][1], MinDp[i-1][2]))+n1;
            MinDp[i][2] = Math.min(MinDp[i-1][1], MinDp[i-1][2])+n2;

        }
        
        bw.write(Math.max(MaxDp[N-1][0], Math.max(MaxDp[N-1][1], MaxDp[N-1][2]))+" "+
                Math.min(MinDp[N-1][0], Math.min(MinDp[N-1][1], MinDp[N-1][2]))+"\n");
        
        bw.flush();
        br.close();
        bw.close();
    }
}
