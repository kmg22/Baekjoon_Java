import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N;
    private static PriorityQueue<int[]> lecture = new PriorityQueue<>(new Comparator<int[]>(){
        @Override
        public int compare(int[] o1, int[]o2){
            if(o1[0]==o2[0]) return o1[1]-o2[1];
            return o1[0]-o2[0];
        }
    });
    private static PriorityQueue<Integer> room = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        String[] input;
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            lecture.add(new int[] {Integer.parseInt(input[0]), Integer.parseInt(input[1])});
        }

        room.add(0);
        while(!lecture.isEmpty()){
            int[] cur = lecture.poll();
            
            if(room.peek()<=cur[0]){
                room.poll();
            }
            room.add(cur[1]);
        }

        bw.write(room.size()+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
