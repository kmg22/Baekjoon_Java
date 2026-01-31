import java.io.*;

public class Main {
    static char[] rowel = {'a', 'e', 'i', 'o', 'u'};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String input = br.readLine();
        while(!input.equals("end")){
            boolean condition_rowel = false; // 조건1.모음 유무 검사
            boolean condition_repeat = true; // 조건2.모음 자음 연속 조건 충족 여부
            boolean condition_sequence = true; // 조건3. 알파벳 반복 검사
            char cur, last='\0';
            int cnt = 0;

            for(int i=0; i<input.length(); i++){
                cur = input.charAt(i);

                if(isRowel(cur)){
                    condition_rowel = true;
                }

                if(isRowel(last) == isRowel(cur)){
                    cnt++;
                    if(cnt > 2){
                        condition_repeat = false;
                        break;
                    }
                }
                else{
                    cnt=1;
                }

                if(last == cur){
                    condition_sequence = false;
                    if(cur == 'e' || cur == 'o'){
                        if(i+1 == input.length() || cur != input.charAt(i+1)){
                            condition_sequence = true;
                        }
                    }
                    
                    if(!condition_sequence){
                        break;
                    }
                }
                last = cur;
            }

            if(condition_rowel && condition_repeat && condition_sequence){ 
                bw.write("<"+input+"> is acceptable.");
            }
            else{
                bw.write("<"+input+"> is not acceptable.");
            }
            bw.newLine();
            bw.flush();
            
            
            input = br.readLine();
        }

        bw.newLine();
        bw.flush();

        br.close();
        bw.close();
    }

    public static boolean isRowel(char c){
        for(int i=0; i<5; i++){
            if(c == rowel[i]){
                return true;
            }
        }
        return false;
    }
}
