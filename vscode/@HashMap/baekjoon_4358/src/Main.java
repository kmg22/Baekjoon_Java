import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception{

        String name;
        float totalNum=0;
        HashMap<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        while((name = br.readLine()) != null && !name.isEmpty()){
            if(!map.containsKey(name)){
                list.add(name);
            }
            map.put(name, map.getOrDefault(name, 0)+1);
            totalNum++;
        }

        Collections.sort(list);
        for(String s : list){
            bw.write(s+String.format(" %.4f\n", map.get(s)/totalNum*100));
        }

        bw.flush();
        br.close();
        bw.close();
    }
}