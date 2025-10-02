import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception{
        int N = Integer.parseInt(br.readLine());

        int[] init = new int[N];
        for(int i=0; i<N; i++){
            init[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(init);

        HashSet<Integer> plusSet = new HashSet<>();
        for(int i=0; i<N; i++){
            for(int j=i; j<N; j++){
                plusSet.add(init[i]+init[j]);
            }
        }

        int result=0;
        out:        
        for(int i=N-1; i>=0; i--){
            for(int j=i; j>=0; j--){
                int minus = init[i]-init[j];

                if(plusSet.contains(minus)){
                    result = init[i];
                    break out;
                }
            }
            // if(result>0){
            //     break;
            // }
        }

        bw.write(result+"\n");

        bw.flush();
        br.close();
        bw.close();
    }

}