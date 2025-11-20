import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 계획 일 수
        int M = Integer.parseInt(input[1]); // 인출 횟수

        int[] plan = new int[N];
        int min=1, max=0, result=0;

        for(int i=0; i<N ;i++){
            plan[i] = Integer.parseInt(br.readLine());
            min = Math.max(min, plan[i]);
            max += plan[i];
        }

        while(min<=max){
            int mid = (min+max)/2; // 인출 한도

            int cnt=1, money=mid; // 첫 날 인출 한도까지 뽑음 | money : 현재 잔액
            for(int x : plan){
                if(money<x){ // 잔액으로 오늘 지출 감당 불가능
                    cnt++;
                    money = mid;
                }
                money -= x;
            }

            if(cnt<=M){
                result = mid;
                max = mid-1;
            }else{
                min = mid+1;
            }
        }

        bw.write(result+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
