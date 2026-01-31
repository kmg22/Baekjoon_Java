import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        int[] A  = new int[N];
        int[] dp = new int[N];

        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            A[i]  = Integer.parseInt(input[i]);
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0;
        for(int i=0; i<N; i++){
            if(dp[i]>= N){ continue; } // MAX_VALUE에 값 더하면 버퍼 오버플로우 가능하니 주의
            for(int j=1;  j<=A[i]; j++){
                int idx = i+j;
                if(idx<N){
                    dp[idx] = Math.min(dp[idx], dp[i]+1);
                }else{ break; }
            }
        }

        int result = dp[N-1];
        if(result>=N){ result = -1; }
        bw.write(result+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
