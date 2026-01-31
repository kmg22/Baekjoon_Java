import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 나무 수
        int M = Integer.parseInt(input[1]); // 목표 나무 길이

        int low=0, high=0;
        int[] logs = new int[N];

        input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            logs[i] = Integer.parseInt(input[i]);
            high = Math.max(high, logs[i]);
        }

        while(low<=high){
            int mid = (low+high)/2;

            long total=0;
            for(int i=0; i<N; i++){
                if(logs[i]>mid){
                    total += logs[i]-mid;
                }
            }

            if(total>=M){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        bw.write(high+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
