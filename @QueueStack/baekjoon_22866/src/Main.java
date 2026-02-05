import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N;
    private static int[] building;
    private static int[][] result; // 볼 수 있는 건물 개수 | 가장 가까운 건물 번호
    private static Stack<Integer> stack;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        building = new int[N+1];
        result = new int[N+1][2];
        
        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            building[i+1] = Integer.parseInt(input[i]);
        }

        // left
        stack = new Stack<>();
        for(int i=1; i<=N; i++){
            result[i][1] = Integer.MAX_VALUE;
            while(!stack.isEmpty() && building[stack.peek()]<=building[i]){
                stack.pop();
            }
            result[i][0] = stack.size();
            if(result[i][0]>0){ result[i][1] = stack.peek(); }
            stack.push(i);
        }

        // right
        stack = new Stack<>();
        for(int i=N; i>0; i--){
            while(!stack.isEmpty() && building[stack.peek()]<=building[i]){
                stack.pop();
            }
            result[i][0] += stack.size();
            if(!stack.isEmpty()){
                // 우측 검사로 인한 빌딩 거리가 더 가까움
                if(Math.abs(i-result[i][1])>Math.abs(i-stack.peek())){
                    result[i][1] = stack.peek();
                }
            }
            stack.push(i);
        }


        for(int i=1; i<=N; i++){
            bw.write(result[i][0]+" ");
            if(result[i][0]>0){ bw.write(result[i][1]+" "); }
            bw.newLine();
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
