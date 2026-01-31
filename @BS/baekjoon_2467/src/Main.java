import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int MAX = 2_000_000_001;

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        int low=0, high=N-1;
        int record=MAX, result_low=0, result_high=0;

        int[] solution = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            solution[i] = Integer.parseInt(input[i]);
        }
        //Arrays.sort(solution); << 입력이 오름차순으로 들어옴

        while(low<high){
            int mix = solution[low] + solution[high];

            int abs_mix = Math.abs(mix);
            if(abs_mix<record){
                record = abs_mix;
                result_low = solution[low];
                result_high = solution[high];
            }

            if(mix<=0){
                low++;
            }else{
                high--;
            }
        }
        bw.write(result_low+" "+result_high+"\n");
        bw.flush();
        
        br.close();
        bw.close();
    }
}
