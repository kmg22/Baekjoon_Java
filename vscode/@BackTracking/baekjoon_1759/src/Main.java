import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int L, C;
    private static String[] words;
    private static boolean[] isVowel;
    private static String[] vowel = {"a", "e", "i", "o", "u"};
    private static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        String[] input = br.readLine().split(" ");
        L = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        words = br.readLine().split(" ");
        Arrays.sort(words);
        isVowel = new boolean[C];

        for(int c=0; c<C; c++){
            for(int i=0; i<5; i++){
                if(words[c].equals(vowel[i])){
                    isVowel[c] = true;
                }
            }
        }

        BackTracking(0, 0, 0, 0);
        
        bw.flush();
        br.close();
        bw.close();
    }

    private static void BackTracking(int idx, int cnt, int vowelCnt, int consonentCnt) throws Exception{
        if(cnt==L){
            if (vowelCnt>=1 && consonentCnt>=2){
                for(int i=0; i<L; i++){
                    bw.write(list.get(i));
                }
                bw.write("\n");
            }
            return;
        }

        // cnt 자리 문자 결정
        for(int i=idx; i<C; i++){
            list.add(cnt, words[i]);
            if(isVowel[i]){
                BackTracking(i+1, cnt+1, vowelCnt+1, consonentCnt);   
            }else{
                BackTracking(i+1, cnt+1, vowelCnt, consonentCnt+1);
            }
        }
    }
}
