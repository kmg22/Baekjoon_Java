import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N;
    private static int[] A, cnt, result;
    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        cnt = new int[1_000_001];
        result = new int[N];

        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            int idx = Integer.parseInt(input[i]);
            cnt[idx]++;
            A[i] = idx;
        }

        Arrays.fill(result, -1);

        for(int i=0; i<N; i++){
            while(!stack.isEmpty() && cnt[A[i]]>cnt[A[stack.peek()]]){
                result[stack.pop()] = A[i];
            }
            stack.push(i);
        }


        for(int i=0; i<N; i++){
            bw.write(result[i]+" ");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
