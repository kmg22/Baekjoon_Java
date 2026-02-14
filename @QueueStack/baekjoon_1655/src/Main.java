import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N;
    private static PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
    private static PriorityQueue<Integer> right = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            int tmp = Integer.parseInt(br.readLine());
            left.add(tmp);
            right.add(left.poll());
            if(left.size()<right.size()){ left.add(right.poll()); }
            bw.write(left.peek()+"\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
