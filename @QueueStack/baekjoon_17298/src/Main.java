import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N;
    private static int[] A;
    private static Stack<int[]> stack = new Stack<>();
    private static int[] result;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        result = new int[N];
        Arrays.fill(result, -1);

        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(input[i]);
        }

        for(int i=0; i<N; i++){

            while(!stack.isEmpty()){
                int[] tmp = stack.peek();
                if(A[i] <= tmp[1]){ break; }

                result[tmp[0]] = A[i];
                stack.pop();
            }
            
            stack.push(new int[] {i, A[i]});
        }
        
        for(int nge : result){
            bw.write(nge+" ");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
