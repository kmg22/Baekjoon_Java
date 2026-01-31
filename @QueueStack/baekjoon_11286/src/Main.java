import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception{
        int N  = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
                @Override
                public int compare(Integer o1, Integer o2){
                    if(Math.abs(o1)==Math.abs(o2)){
                        if(o1<o2){ return -1; } // o1이 높은 우선순위
                        else { return 1;} // 02가 높은 우선순위
                    }else{
                        return Math.abs(o1)-Math.abs(o2);
                    }
                }
            });
        
        for(int i=0; i<N; i++){
            int X = Integer.parseInt(br.readLine());

            switch(X){
                case 0:
                    if(!pq.isEmpty()){
                        bw.write(pq.poll()+"\n");
                    }else{
                        bw.write("0\n");
                    }
                    break;
                default:
                    pq.offer(X);
                    break;
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}