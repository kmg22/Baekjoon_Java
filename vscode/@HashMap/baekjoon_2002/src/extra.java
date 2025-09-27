import java.io.*;
import java.util.*;

public class extra{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws Exception{
        int N = Integer.parseInt(br.readLine());
        
        LinkedHashMap<String, Integer> set = new LinkedHashMap<>();
        String input;
        for(int i=0; i<N; i++){
            input = br.readLine();
            set.put(input, i);
        }

        int cnt=0;
        for(int i=0; i<N; i++){
            input = br.readLine();
            Iterator<String> it = set.keySet().iterator();
            while(it.hasNext()){
                if(set.get(input) > set.get(it.next())){
                    cnt++;
                    // break; // 27, 28행 삭제하고 이곳에 break; 추가해도 됨
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