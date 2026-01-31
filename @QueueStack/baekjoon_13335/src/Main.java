import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // 트럭 수
        int w = Integer.parseInt(input[1]); // 다리 길이
        int L = Integer.parseInt(input[2]); // 최대하중

        Queue<Integer> truck = new LinkedList<>();
        input = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            truck.add(Integer.parseInt(input[i]));
        }

        Queue<Integer> bridge = new LinkedList<>();
        for(int i=0; i<w; i++){ bridge.add(0); }

        int cnt=0, sum=0;
        while(!bridge.isEmpty()){
            sum -= bridge.poll();

            if(!truck.isEmpty()){
                if(truck.peek()+sum<=L){
                    int tmp = truck.poll();
                    sum += tmp;
                    bridge.add(tmp);
                }else{
                    bridge.add(0);
                }
            }
            cnt++;
        }

        bw.write(cnt+"");

        bw.flush();
        br.close();
        bw.close();
    }
}