import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int T, K;
    private static String[] input;
    private static PriorityQueue<Integer> pqMin, pqMax;
    private static HashMap<Integer, Integer> map;

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());
        while(T-->0){
            K = Integer.parseInt(br.readLine());
            pqMin = new PriorityQueue<>();
            pqMax = new PriorityQueue<>(Collections.reverseOrder());
            map = new HashMap<>();

            for(int k=0; k<K; k++){
                input = br.readLine().split(" ");
                int num = Integer.parseInt(input[1]);
                switch(input[0].charAt(0)){
                    case 'I':
                        pqMin.add(num);
                        pqMax.add(num);
                        map.put(num, map.getOrDefault(num,0)+1);
                        break;
                    case 'D':
                        if(!isEmpty()){
                            switch(num){
                                case 1:
                                    delete(pqMax);
                                    break;
                                case -1:
                                    delete(pqMin);
                                    break;
                            }
                        }
                        break;
                }
            }

            if(!isEmpty()){ 
                int max = delete(pqMax);
                int min = !isEmpty() ? delete(pqMin) : max;
                bw.write(max +" "+ min +"\n");              
            }
            else{ 
                bw.write("EMPTY\n");
            }
        }

        
        bw.flush();
        br.close();
        bw.close();
    }

    private static boolean isEmpty(){
        return map.size()==0;
    }

    private static int delete(PriorityQueue<Integer> pq){
        int del=0;
        while(!pq.isEmpty()){
            del = pq.poll();
            int cnt = map.getOrDefault(del, 0);
            boolean flag=true;

            switch(cnt){
                case 0:
                    flag = false;
                    break;
                case 1:
                    map.remove(del);
                    break;
                default:
                    map.put(del, cnt-1);
                    break;
            }
            if(flag){break;}
        }
        return del;
    }
}
