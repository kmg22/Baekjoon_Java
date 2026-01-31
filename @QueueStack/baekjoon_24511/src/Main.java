import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());

        String[] ds = br.readLine().split(" "); // data structure
        String[] init = br.readLine().split(" "); // initial input
        Deque<Integer> queue = new LinkedList<>();
        for(int i=0; i<N; i++){
            switch(ds[i]){
                case "0": // queue
                    queue.addFirst(Integer.parseInt(init[i]));
                    break;
                case "1": // stack ... 바로 삽입, 삭제하면 아무일도 안 일어나는 것과 같음
                    break;
            }
        }

        int M = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" "); // insert list
        for(int i=0; i<M; i++){
            queue.add(Integer.parseInt(input[i]));
            bw.write(queue.pollFirst()+" ");
        }

        bw.flush();
        br.close();
        bw.close();
        
    }
}
