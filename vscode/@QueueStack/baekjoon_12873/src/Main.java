import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=N; i++){ q.add(i); }

        int left = N;
        for(int i=1; i<N; i++){
            long t3 = (long) i*i*i; // 버퍼 오버플로우가 발생하지 않도록 주의
            int mv = (int) (t3%left);

            if(mv==0){ mv = left;}
            for(int j=1; j<=mv; j++){
                int x = q.poll();
                if(j!=mv) { q.add(x); }
            }
            left--;
        }

        bw.write(String.valueOf(q.poll()));
        bw.flush();

        br.close();
        bw.close();
    }
}