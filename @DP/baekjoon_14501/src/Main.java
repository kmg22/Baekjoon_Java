import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] F = new int[N+2];
        Arrays.fill(F, 0);

        for(int i=1; i<=N; i++){
            String[] input = br.readLine().split(" ");
            int T = Integer.parseInt(input[0]);
            int P = Integer.parseInt(input[1]);
            
            F[i] = Math.max(F[i-1], F[i]);
            if(i+T <= N+1) // 상담 진행 가능
                F[i+T] = Math.max(F[i+T], F[i]+P);
        
        }
        F[N+1] = Math.max(F[N], F[N+1]);
        bw.write(F[N+1]+"");
        bw.flush();

        br.close();
        bw.close();
    }
}
