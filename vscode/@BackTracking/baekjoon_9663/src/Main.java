import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[] arr;
    private static int N, result=0;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        
        nQueen(0);

        bw.write(result+"\n");
        bw.flush();
        br.close();
        bw.close();
    }

    private static void nQueen(int cnt){
        if(cnt==N){
            result++;
            return;
        }

        for(int i=0; i<N; i++){
            arr[cnt]=i; // cnt행의 i번째 놓기
            if(possible(cnt)){
                nQueen(cnt+1);
            }
        }
    }

    private static boolean possible(int cnt){
        for(int i=0; i<cnt; i++){
            // 직선 검사 (한 행에는 무조건 하나씩)
            if(arr[cnt] == arr[i]){
                return false;
            }

            // 대각선 검사
            if(Math.abs(cnt-i) == Math.abs(arr[cnt]-arr[i])){
                return false;
            }
        }
        return true;
    }
}
