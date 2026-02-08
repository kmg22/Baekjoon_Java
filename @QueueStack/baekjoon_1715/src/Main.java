import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, result=0;
    private static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }

        while(pq.size()>1){
            int pack1 = pq.poll();
            int pack2 = pq.poll();
            result += pack1+pack2;
            pq.add(pack1+pack2);
        }
        bw.write(result+"\n");
        
        bw.flush();
        br.close();
        bw.close();
    }
}