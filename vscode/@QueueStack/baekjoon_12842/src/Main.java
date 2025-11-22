import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 튀김 소보루 개수
        int S = Integer.parseInt(input[1]); // 남은 빵 개수
        int X = N-S;
        int result=0, cnt=0;
        boolean flag = false;

        int M = Integer.parseInt(br.readLine()); // 사람 수
        int[] speed = new int[M];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<M; i++){
            speed[i] = Integer.parseInt(br.readLine());
        }

        for(int i=1; i<=Integer.MAX_VALUE; i++){
            // 해당 시간에 빵을 먹기 시작한 사람 계산
            for(int j=0; j<M; j++){
                if((i-1)%speed[j]==0){
                    pq.add(j);
                }
            }

            // 우선순위 순서대로 빵 개수 추가
            while(!pq.isEmpty()){
                result = pq.poll();
                cnt++;
                if(cnt==X){
                    flag=true;
                    break;
                }
            }

            // 정답 탐색 성공
            if(flag){
                break;
            }
        }

        // 사람 인덱스 번호 보정
        result++;
        bw.write(result+"\n");
        bw.flush();

        br.close();
        bw.close();
    }
}
