import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static long N, P, Q;
    private static HashMap<Long, Long> map;

    public static void main(String[] args) throws Exception{
        String[] input = br.readLine().split(" ");
        N = Long.parseLong(input[0]);
        P = Integer.parseInt(input[1]);
        Q = Integer.parseInt(input[2]);

        map = new HashMap<>();
        map.put(0L, 1L);
        bw.write(calc(N)+"\n");

        // 메모리 사용량 확인
        // Runtime.getRuntime().gc();
        // long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        // bw.write(usedMemory + " bytes");

        bw.flush();
        br.close();
        br.close();
    }

    public static long calc(long i){
        if(map.containsKey(i)){
            return map.get(i);
        }
        map.put(i, calc(i/P)+calc(i/Q));
        return map.get(i);
    }

}