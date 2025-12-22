import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        String input;
        BigInteger[] dp = new BigInteger[251];

        dp[0] = new BigInteger("1");
        dp[1] = new BigInteger("1");
        dp[2] = new BigInteger("3");

        for(int i=3; i<251; i++){
            dp[i] = dp[i-1].add(dp[i-2].multiply(BigInteger.TWO));
        }

        while((input=br.readLine())!=null && !input.isEmpty()){
            int N = Integer.parseInt(input);
            bw.write(dp[N]+"\n");
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}
