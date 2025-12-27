import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        int[][] C = new int[30][30];
        
        C[1][1]=1;
        C[1][0]=1;
        for(int i=2; i<30; i++){
            C[i][i]=1;
            C[i][0]=1;
            for(int j=1; j<30; j++){
                if(i!=j){
                    C[i][j] = C[i-1][j-1] + C[i-1][j];      
                }
            }
        }

        while(T-->0){
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            bw.write(C[M][N]+"\n");
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}
