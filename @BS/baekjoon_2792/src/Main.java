import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 아이들 수
        int M = Integer.parseInt(input[1]); // 보석 색상 수
        int[] jewel = new int[M];

        int low=1, high=0, result=0;

        for(int i=0; i<M; i++){
            jewel[i] = Integer.parseInt(br.readLine());
            high = Math.max(high, jewel[i]);
        }

        while(low<=high){
            int mid=(low+high)/2; // 질투심

            int cnt=0; // 아이들 수
            for(int i=0; i<M; i++){
                cnt+=jewel[i]/mid;
                if(jewel[i]%mid > 0){cnt++;}
            }

            if(cnt<=N){ 
                result = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        bw.write(result+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
