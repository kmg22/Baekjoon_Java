import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        String[] input = br.readLine().split(" ");
        int K = Integer.parseInt(input[0]); // 갖고 있는 랜선 수
        int N = Integer.parseInt(input[1]); // 필요 랜선 개수

        int[] LANs = new int[K]; // 갖고 있는 랜선 길이 저장

        long min=1, max=0;
        long result=0;
        for(int i=0; i<K; i++){
            LANs[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, LANs[i]);
        }

        while(min<=max){
            long mid = (min+max)/2;

            long cnt=0;
            for(int i=0; i<K; i++){
                cnt += LANs[i]/mid;
            }

            if(cnt>=N){
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
