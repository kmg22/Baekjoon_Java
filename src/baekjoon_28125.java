// [silver4] 2023 아주머학교 프로그래딩 정시머힌 | 28125
// https://www.acmicpc.net/problem/28125
import java.util.Scanner;

public class baekjoon_28125 {
    private static String test(String[] chrs){
        String[][] dic = {{"@", "a"},{"[","c"},{"!","i"},{";","j"},{"^","n"},
                {"0","o"},{"7","t"},{"\\\'","v"},{"\\\\\'","w"}};

        String re = "";
        int cnt=0;
        boolean isunder = true;
        int strlen = chrs.length;

        for(int i=0; i<chrs.length; i++) {
            for(int j=0; j<dic.length; j++){
                if(chrs[i].equals(dic[j][0])){
                    re += dic[j][1];
                    cnt++;

                    if(dic[j][1].equals("v"))
                        strlen--;
                    else if(dic[j][1].equals("w"))
                        strlen -= 2;

                    break;
                }
                if (j+1 == dic.length)
                    re += chrs[i]; // 암호 아닌 경우 원래 문제 붙이기
            }

            if(strlen%2 == 1)
                strlen ++;

            if(cnt>=strlen/2) {
                isunder = false;
                break;
            }
        }
        if(!isunder)
            re = "I don't understand";
        return re;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        String[] str = new String[N];

        for(int i=0; i<N; i++){
            String tmpstr = scan.next();
            int len = tmpstr.length();
            char[] chr = tmpstr.toCharArray(); // 초기 입력 String -> char 변환
            String[] chrs = new String[len];

            for(int j=0; j<tmpstr.length(); j++){ // 각 char를 String으로 변환
                try{
                    if(chr[j] == '\\' && chr[j+1]=='\''){
                        chrs[j] = "\\\'";
                        chrs[j+1] = "";
//                        len--;
                        j++;
                    }
                    else if(chr[j] =='\\' && chr[j+1]=='\\' && chr[j+2]=='\''){
                        chrs[j] = "\\\\\'";
                        chrs[j+1] = chrs[j+2] = "";
//                        len -= 2;
                        j += 2;
                    }
                    else
                        chrs[j] = String.valueOf(chr[j]);
                }catch(NullPointerException e) {
                    chrs[j] = String.valueOf(chr[j]);
                    break;
                }
            }
            str[i] = test(chrs);
        }
        for(String x : str)
            System.out.println(x);
    }
}