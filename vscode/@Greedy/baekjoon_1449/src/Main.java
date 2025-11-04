import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int L = Integer.parseInt(input[1]);
        int cnt=1;

        List<Integer> leak = new ArrayList<>();
        input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            int loc = Integer.parseInt(input[i]);
            leak.add(loc);
        }
        Collections.sort(leak);

        int top=leak.get(0)+L; // 다음 테이프 최소 시작 위치
        for(int i=1; i<N; i++){
            if(top <= leak.get(i)){
                cnt++;
                top = leak.get(i)+L;
            }
        }

        bw.write(cnt+"\n");
        bw.flush();
        
        br.close();
        bw.close();
    }
}
