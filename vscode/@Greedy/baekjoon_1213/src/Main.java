import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        String input = br.readLine();
        int[] eng = new int[26];
        boolean isPossible = true;
        int odd_cnt=0, odd_num=0;

        for(int i=0; i<input.length(); i++){
            int e = input.charAt(i)-'A';
            eng[e]++;
        }
        
        for(int i=0; i<26; i++){
            if(eng[i]%2!=0){ // 홀수 개수 알파벳
                odd_cnt++;
                odd_num = i;
                isPossible = odd_cnt>=2 ? false : true;
            }
        }

        if(isPossible){
            StringBuilder front_sb = new StringBuilder();
            for(int i=0; i<26; i++){
                for(int j=0; j<eng[i]/2; j++){
                    front_sb.append((char)(i+'A'));
                }
            }
            StringBuilder result_sb = new StringBuilder(front_sb.toString());
            if(odd_cnt>0){ result_sb.append((char)(odd_num+'A')); }
            result_sb.append(front_sb.reverse());

            bw.write(result_sb.toString()+"\n");
        }else{
            bw.write("I'm Sorry Hansoo\n");
        }
        
        bw.flush();
        br.close();
        bw.close();
    }
}
