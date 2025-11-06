import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        boolean[] arr = new boolean[N];
        input = br.readLine().split("");
        for(int i=0; i<N; i++){
            if(input[i].equals("H")){
                arr[i] = true;
            }
        }

        int cnt=0;
        for(int i=0; i<N; i++){
            if(input[i].equals("H")){ continue; }

            for(int k=-K; k<=K; k++){
                if(k==0){ continue; }

                int tmp=i+k;
                if(tmp>=0 && tmp<N){
                    if(arr[tmp]){
                        arr[tmp] = false;
                        cnt++;
                        break;
                    }
                }

            }
        }
        bw.write(cnt+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
