import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N;
    private static Stack<int []> top = new Stack<>();

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        for(int i=1; i<=N; i++){
            int height = Integer.parseInt(input[i-1]);

            while(!top.isEmpty()){
                if(height <= top.peek()[1]){
                    bw.write(top.peek()[0] + " ");
                    break;
                }
                top.pop();
            }
            if(top.isEmpty()){
                bw.write("0 ");
            }
            top.push(new int[] {i, height});
        }

        bw.newLine();
        bw.flush();
        br.close();
        bw.close();
    }
}
