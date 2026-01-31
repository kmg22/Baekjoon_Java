import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws Exception{
        int N = Integer.parseInt(br.readLine());
        
        Set<String> set = new LinkedHashSet<>();
        String input;
        for(int i=0; i<N; i++){
            input = br.readLine();
            set.add(input);
        }

        int cnt=0;
        for(int i=0; i<N; i++){
            input = br.readLine();
            for(String s : set){
                if(!s.equals(input)){
                    cnt++;
                }
                set.remove(input);
                break;
            }
        }
        bw.write(cnt+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}