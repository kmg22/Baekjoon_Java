import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int K = Integer.parseInt(input[0]);
        int L = Integer.parseInt(input[1]);

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for(int i=0; i<L; i++){
            String id = br.readLine();

            if(map.containsKey(id)){
                map.remove(id);
            }
            map.put(id, 1);
        }

        int cnt=0;
        for(String id : map.keySet()){
            if(cnt<K){
                bw.write(id+"\n");
                cnt++;
            }else{
                break;
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}