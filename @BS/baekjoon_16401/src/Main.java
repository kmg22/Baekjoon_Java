import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]); // 조카 수
        int N = Integer.parseInt(input[1]); // 과자 수

        int[] snacks = new int[N];
        long min=1, max=0, result=0;
        input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            snacks[i] = Integer.parseInt(input[i]);
            max = Math.max(max, snacks[i]);
        }

        while(min<=max){
            long mid = (min+max)/2;

            int cnt=0;
            for(int i=0; i<N; i++){
                cnt += snacks[i]/mid;
            }

            if(cnt>=M){
                result = mid;
                min = mid+1;
            }else{
                max = mid-1;
            }

        }
        bw.write(result+"\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
