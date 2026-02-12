import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N;
    private static PriorityQueue<int[]> lecture = new PriorityQueue<>((a,b)->a[1]-b[1]); // 마감 날짜 짧은 거 먼저 poll
    private static PriorityQueue<Integer> decision = new PriorityQueue<>(); // 저렴한 pay 먼저 poll

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        String[] input;
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            lecture.add(new int[] { Integer.parseInt(input[0]), Integer.parseInt(input[1])} );
        }

        while(!lecture.isEmpty()){
            int[] lec = lecture.poll();
            decision.add(lec[0]);
            if(decision.size()>lec[1]){
                decision.poll();
            }
        }

        int pay=0;
        while(!decision.isEmpty()){
            pay += decision.poll();
        }

        bw.write(pay+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
