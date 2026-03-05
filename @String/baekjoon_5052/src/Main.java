import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int T, N;
    private static String[] nums;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            N = Integer.parseInt(br.readLine());
            nums = new String[N];

            for(int i=0; i<N; i++){
                nums[i] = br.readLine();
            }
            Arrays.sort(nums);

            bw.write(check()?"YES\n":"NO\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static boolean check(){
        for(int i=0; i<N-1; i++){
            if(nums[i+1].startsWith(nums[i])){
                return false;
            }
        }
        return true;
    }
}
