// 큐 | 시간초과
import java.util.*;
import java.io.*;

public class try1{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 손님 수
        int M = Integer.parseInt(input[1]); // 초밥 수

        Queue<Integer>[] guest = new LinkedList[N];
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            guest[i] = new LinkedList<>();
            for(int j=1; j<=Integer.parseInt(input[0]); j++){
                guest[i].add(Integer.parseInt(input[j]));
            }
        }

        Queue<Integer> menu = new LinkedList();
        input = br.readLine().split(" ");
        for(int j=0; j<input.length; j++){
            menu.add(Integer.parseInt(input[j]));
        }

        int[] cnt = new int[N];
        while(!menu.isEmpty()){
            int sushi = menu.poll();

            for(int i=0; i<N; i++){
                if(guest[i].remove(sushi)){
                    cnt[i]++;
                    break;
                }
            }
        }

        for(int n : cnt){
            bw.write(n+" ");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}