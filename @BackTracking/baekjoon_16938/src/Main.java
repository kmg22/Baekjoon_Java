import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, L, R, X, result=0;
    private static int[] A;
    private static boolean[] check;
    public static void main(String[] args) throws Exception {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        L = Integer.parseInt(input[1]); // 난이도 합 하한선
        R = Integer.parseInt(input[2]); // 난이도 합 상한선
        X = Integer.parseInt(input[3]); // 난이도 차 하한선

        A = new int[N];
        check = new boolean[N];
        input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(input[i]);
        }

        backtracking(0, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
        bw.write(result+"\n");
        bw.flush();
        br.close();
        bw.close();
    }

    // 문제 인덱스 | 선택된 문제 개수 | 난이도 합 | 선택된 난이도 최댓값 | 선택된 난이도 최소값
    private static void backtracking(int idx, int cnt, int sum, int max, int min){
        if(cnt>=2 && check[idx-1]){
            if(sum>R){ return; }
            if(L<=sum && X<=(max-min)){ result++; }
        }

        if(idx==N){ return; }

        // idx번 문제 포함
        check[idx]=true;
        backtracking(idx+1, cnt+1, sum+A[idx], Math.max(max, A[idx]), Math.min(min, A[idx]));

        // idx번 문제 미포함
        check[idx]=false;
        backtracking(idx+1, cnt, sum, max, min);
    }

}
