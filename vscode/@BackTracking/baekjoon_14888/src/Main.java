import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, plus, minus, multi, div;
    private static int resultMin=Integer.MAX_VALUE, resultMax=Integer.MIN_VALUE;
    private static int[] arr;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        
        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");
        plus  = Integer.parseInt(input[0]);
        minus = Integer.parseInt(input[1]);
        multi = Integer.parseInt(input[2]);
        div   = Integer.parseInt(input[3]);
        
        BackTracking(1, arr[0], 0, 0, 0, 0);
        
        bw.write(resultMax+"\n"+resultMin+"\n");
        bw.flush();
        br.close();
        bw.close();

    }

    private static void BackTracking(int idx, int val, int plCnt, int miCnt, int muCnt, int diCnt){
        if(plCnt>plus || miCnt>minus || muCnt>multi || diCnt>div){
            return;
        }

        if(idx==N){
            resultMin = Math.min(resultMin, val);
            resultMax = Math.max(resultMax, val);
            return;
        }

        int next = arr[idx];
        BackTracking(idx+1, val+next, plCnt+1, miCnt, muCnt, diCnt);
        BackTracking(idx+1, val-next, plCnt, miCnt+1, muCnt, diCnt);
        BackTracking(idx+1, val*next, plCnt, miCnt, muCnt+1, diCnt);
        BackTracking(idx+1, val/next, plCnt, miCnt, muCnt, diCnt+1);

    }
}
