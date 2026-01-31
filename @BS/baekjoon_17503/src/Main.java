import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 축제 기간
        int M = Integer.parseInt(input[1]); // 선호도 합
        int K = Integer.parseInt(input[2]); // 맥주 종류
        
        long low=1, high=0, result=-1;
        int[][] beer = new int[K][2];
        for(int i=0; i<K; i++){
            input = br.readLine().split(" ");
            beer[i][0] = Integer.parseInt(input[0]); // 선호도
            beer[i][1] = Integer.parseInt(input[1]); // 도수 레벨
            high = Math.max(high, beer[i][1]);
        }
        Arrays.sort(beer, new Comparator<int[]>() {
            // 선호도 기준 내림차순 정렬(priority queue를 사용해도 좋을 듯)
            @Override
            public int compare(int[] o1, int[] o2){
                return o2[0]-o1[0];
            }
        });

        /*
         * [조건]
         * 선호도 합 >= M
         * 도수 레벨 합 최소
         */
        while(low<=high){
            long mid = (low+high)/2; // 간 레벨 제한

            int n=0;
            int cnt=0; // 임시 선호도
            boolean flag=false;
            for(int i=0; i<K; i++){
                if(beer[i][1]<=mid){
                    cnt += beer[i][0];
                    n++;
                }
                if(n == N){ 
                    flag = true;
                    break;
                }
            }

            if(flag && cnt>=M){
                result = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        bw.write(result+"\n");
        bw.flush();

        bw.close();
        br.close();
    }
}
