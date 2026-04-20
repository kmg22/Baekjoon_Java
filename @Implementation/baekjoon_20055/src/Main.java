import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, K, L, cnt=0;
    private static int[] A;
    private static boolean[] existRobot;

    public static void main(String[] args) throws Exception {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        L = 2*N;

        A = new int[L];
        existRobot = new boolean[L];

        input = br.readLine().split(" ");
        for(int i=0; i<L; i++){
            A[i] = Integer.parseInt(input[i]);
        }

        int step=0;
        int in=0;
        int out=N-1;

        while(cnt<K){
            step++;

            // rotation
            in = (in-1+L)%L;
            out = (in+N-1)%L;
            if(existRobot[out]){ existRobot[out]=false; }

            // move Robot
            for(int x=N-2; x>0; x--){
                int tmp = (in+x)%L;
                int next = (tmp+1)%L;
                if(existRobot[tmp] && !existRobot[next] && A[next]>0){
                    existRobot[tmp] = false;
                    existRobot[next] = true;
                    if(--A[next]==0){cnt++;}
                }
            }
            if(existRobot[out]){ existRobot[out]=false; }

            // add Robot
            if(A[in]>0){
                existRobot[in] = true;
                if(--A[in]==0){cnt++;}
            }
        }

        bw.write(step+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
