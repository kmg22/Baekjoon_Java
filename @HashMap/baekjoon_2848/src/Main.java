import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception{

        String[] input = br.readLine().split(" ");
        String S = input[0];
        String E = input[1];
        String Q = input[2];

        Set<String> enterSet = new HashSet<>();
        Set<String> attendSet = new HashSet<>();

        String line;
        while((line=br.readLine())!=null && !line.isEmpty()){
            String time = line.split(" ")[0];
            String name = line.split(" ")[1];

            // (HH:MM)형식 일치하므로 문자열 비교 가능
            if(time.compareTo(S)<=0){ // 시작 입장 전
                enterSet.add(name);
            }
            if(time.compareTo(E)>=0 && time.compareTo(Q)<=0){
                if(enterSet.contains(name)){
                    attendSet.add(name);
                }
            }
        }

        bw.write(attendSet.size()+"");

        bw.flush();
        br.close();
        bw.close();
    }
}