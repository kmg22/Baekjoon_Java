import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String str = br.readLine();
        String bomb = br.readLine();
        int len = bomb.length();

        for(int i=0; i<str.length(); i++){
            sb.append(str.charAt(i));

            if(sb.length() < len){ continue; }

            String sub = sb.substring(sb.length()-len, sb.length());
            if(sub.equals(bomb)){
                sb.delete(sb.length()-len, sb.length());
            }
        }

        if(sb.length()==0){
            bw.write("FRULA\n");
        }else{
            bw.write(sb.toString()+"\n");
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}
