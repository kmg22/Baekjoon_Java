import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N;
    private static PriorityQueue<int[]> task = new PriorityQueue<>((a,b)->a[0]-b[0]);   // 마감 기한 낮은 것부터 out
    private static PriorityQueue<Integer> selected = new PriorityQueue<>();             // 과제 점수 낮은 것부터 out

    public static void main(String[] args) throws Exception{
        N=Integer.parseInt(br.readLine());
        String[] input;
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            task.add(new int[] {Integer.parseInt(input[0]), Integer.parseInt(input[1])});
        }

        while(!task.isEmpty()){
            int[] cur = task.poll();
            selected.add(cur[1]);
            // 마감 기한 내 해결할 수 있는 작업 수 초과하면 점수 낮은 것 out
            if(selected.size()>cur[0]){ selected.poll(); } 
        }

        int result=0;
        while(!selected.isEmpty()){
            result += selected.poll();
        }

        bw.write(result+"\n");

        bw.flush();
        br.close();
        bw.close();
    }
}