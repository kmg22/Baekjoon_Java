import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            String[] input = br.readLine().split("\\.");
            String key = input[1];
            
            if(!map.containsKey(key)){
                list.add(key);
            }
            map.put(key, map.getOrDefault(key, 0)+1);
        }

        Collections.sort(list);
        for(String s : list){
            bw.write(s + " " + map.get(s) +"\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}