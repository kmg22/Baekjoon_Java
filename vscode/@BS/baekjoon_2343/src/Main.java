import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws Exception {
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // lecture 수
        int M = Integer.parseInt(input[1]); // blue-ray 수
        int low=0, high=0, result=0;

        int[] lecture = new int[N];
        input= br.readLine().split(" ");
        for(int i=0; i<N; i++){
            lecture[i] = Integer.parseInt(input[i]);
            high += lecture[i];
            low = Math.max(low, lecture[i]); // blue-ray는 강의를 중간에 끊을 수 없음
        }

        while(low<=high){
            int mid = (low+high)/2;

            int time=0, cnt=1;
            for(int i=0; i<N; i++){
                if(time + lecture[i] > mid){
                    time = lecture[i];
                    cnt++;
                }else{
                    time+=lecture[i];
                }
            }

            if(cnt<=M){
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
