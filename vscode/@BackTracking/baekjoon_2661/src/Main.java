import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N;
    private static boolean flag;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());

        backtracking(1, "1");

        bw.flush();
        br.close();
        bw.close();
    }

    private static void backtracking(int len, String str) throws Exception{
        if(flag){ return; }

        if(len==N){
            bw.write(str+"\n");
            flag = true;
            return;
        }

        for(int i=1; i<=3; i++){
            String tmp = str+i;
            if(check(tmp)){
                backtracking(len+1, tmp);
            }
        }
    }

    private static boolean check(String str){
        for(int i=1; i<=str.length()/2; i++){
            String back = str.substring(str.length()-i, str.length());
            String front = str.substring(str.length()-2*i, str.length()-i);
            if(back.equals(front)){ return false; }
        }
        return true;
    }

}
