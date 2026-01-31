import java.io.*;
import java.util.*;

public class Main {
    private static final int MAX_SIZE = 200_000;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 손님 수
        int M = Integer.parseInt(input[1]); // 초밥 수

        Queue<Integer>[] q = new LinkedList[MAX_SIZE+1];
        for(int i=1; i<=MAX_SIZE; i++){
            q[i] = new LinkedList<>();
        }

        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=1; j<=Integer.parseInt(input[0]); j++){
                q[Integer.parseInt(input[j])].add(i);
            }
        }

        input = br.readLine().split(" ");
        int[] cnt = new int[N];
        for(int i=0; i<M; i++){
            int sushi = Integer.parseInt(input[i]);
            if(!q[sushi].isEmpty()){
                cnt[q[sushi].poll()]++;
            }
        }

        for(int n : cnt){
            bw.write(n+" ");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}