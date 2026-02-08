import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N;
    private static String[] input;
    private static PriorityQueue<int[]> conference = new PriorityQueue<>(new Comparator<int[]>(){
        @Override
        public int compare(int[] o1, int[] o2){
            if(o1[0]==o2[0]){ return o1[1]-o2[1]; }
            return o1[0]-o2[0];
        }
    });
    private static PriorityQueue<Integer> room = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            conference.add(new int[]{Integer.parseInt(input[0]), Integer.parseInt(input[1])});
        }

        room.add(0);
        while(!conference.isEmpty()){
            int[] lecture_t = conference.poll();
            int start = lecture_t[0];
            int end = lecture_t[1];
            int room_t = room.peek();
            
            if(room_t <= start){
                room.poll();
                room.add(end);
            }else{
                room.add(end);
            }
        }

        bw.write(room.size()+"\n");
        
        bw.flush();
        br.close();
        bw.close();
    }
}
