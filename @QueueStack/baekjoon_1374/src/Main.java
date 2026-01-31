import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int N = Integer.parseInt(br.readLine());
        int lecture_cnt=1;
        PriorityQueue<Long> pq = new PriorityQueue<>(); // 가장 빠르게 이용 가능한 강의실 시간
        PriorityQueue<long[]> lecture = new PriorityQueue<>(
            Comparator.comparingLong((long[] a)->a[0])
                    .thenComparingLong(a->a[1]) // 시작 시간 같으면 종료시간 비교
        );

        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            // 강의실 번호는 불필요한 정보라 제외
            long start_t  = Long.parseLong(input[1]);
            long finish_t = Long.parseLong(input[2]);
            lecture.offer(new long[]{start_t, finish_t});
        }
        pq.offer(0L); // 초기 강의실 1개 삽입

        while(!lecture.isEmpty()){
            long[] e = lecture.poll();
            long start_t = e[0];
            long finish_t = e[1];
            long avail_t = pq.peek();

            if(start_t >= avail_t){ // 기존 강의실 사용 가능
                pq.poll();
                pq.offer(finish_t);
            }else{ // 새 강의실 추가
                pq.offer(finish_t);
                lecture_cnt++;
            }
        }
        bw.write(lecture_cnt+"\n");
        bw.flush();
        
        br.close();
        bw.close();
    }
}
