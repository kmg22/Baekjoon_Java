import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static long result;
    private static String str;
    // private static char[] vowel = {'A', 'E', 'I', 'O', 'U'};

    public static void main(String[] args) throws Exception {
        str = br.readLine();

        result = backtracking(0, 0, 0, false);

        bw.write(result+"\n");
        bw.flush();
        br.close();
        bw.close();
    }

    // 현재 위치 | 연속 모음 수 | 연속 자음 수 | L 포함 여부
    private static long backtracking(int idx, int vCnt, int cCnt, boolean hasL){
        if(vCnt>=3 || cCnt>=3){ return 0; }
        if(idx == str.length()){ return hasL? 1 : 0; }
        
        long cnt=0;
        char cur = str.charAt(idx);
        if(cur=='_'){
            // 모음(5개) 삽입
            cnt += 5*backtracking(idx+1, vCnt+1, 0, hasL);

            // L 삽입
            cnt += backtracking(idx+1, 0, cCnt+1, true);

            // L 제외 자음(20개) 삽입
            cnt+= 20*backtracking(idx+1, 0, cCnt+1, hasL);
        }else{ // 이미 정해진 알파벳

            // 자음
            if(isVowel(cur)){
                cnt = backtracking(idx+1, vCnt+1, 0, hasL);
            }
            // 모음
            else{
                cnt = backtracking(idx+1, 0, cCnt+1, (hasL||(cur=='L')));
            }
        }
        return cnt;
    }

    private static boolean isVowel(char c){
        return c=='A' || c=='E' || c=='I' ||  c=='O' ||  c=='U';
    }
}
