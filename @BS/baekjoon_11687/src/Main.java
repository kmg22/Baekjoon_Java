import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int M = Integer.parseInt(br.readLine());
        int low=0, high=M*5, result=-1;
        boolean flag=false;
        
        while(low<=high){
            int tmp = (low+high)/2;
            int mid =  tmp - tmp%5; // 5의 배수 되도록 정규화

            int cnt=0;
            for(int i=5; i<=mid; i*=5){
                cnt += mid/i;
            }

            if(cnt<=M){
                if(cnt==M){flag=true;}
                result = mid;
                low = mid+5;
            }else{
                high = mid-5;
            }
        }
        if(!flag){result=-1;}
        bw.write(result+"\n");
        bw.flush();
        
        br.close();
        bw.close();
    }
}
