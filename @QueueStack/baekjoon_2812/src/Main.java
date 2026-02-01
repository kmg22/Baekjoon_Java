import java.io.*;
import java.util.*;


public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, K;
    private static Stack<Character> stack = new Stack<>();
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        char[] nums = br.readLine().toCharArray();

        int rmv=0;
        for(int i=0; i<N; i++){
            while(rmv<K && !stack.isEmpty() && stack.peek()<nums[i]){
                stack.pop();
                rmv++;
            }
            stack.push(nums[i]);
        }

        for(int i=0; i<N-K; i++){
            sb.append(stack.get(i));
        }
        bw.write(sb.toString()+"\n");
        
        bw.flush();
        br.close();
        bw.close();
    }
}
