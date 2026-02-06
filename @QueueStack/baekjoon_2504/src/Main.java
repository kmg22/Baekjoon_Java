import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static Stack<Character> stack = new Stack<>();
    private static int result=0;
    private static boolean flag=true;

    public static void main(String[] args) throws Exception {
        String input = br.readLine();
        for(int i=0; i<input.length(); i++){
            stack.push(input.charAt(i));
        }

        while(!stack.isEmpty()){
            char tmp = stack.pop();

            switch(tmp){                
                case ')':
                case ']':
                    result += calc(tmp);
                    break;
                
                default :
                    // 닫힘 괄호 없이 열린 괄호 주어짐
                    flag=false; 
                    break;
            }
            if(!flag){ break; }
        }

        if(!stack.isEmpty() || !flag){result=0;}
        bw.write(result+"\n");
        
        bw.flush();
        br.close();
        bw.close();
    }

    private static int calc(char c){
        int points=0;
        if(c==')'){ 
            c = '(';
            points = 2;
        }
        if(c==']'){
            c = '[';
            points = 3;
        }

        char next='\0';
        int inner=0;
        while(!stack.isEmpty() && (next=stack.pop())!=c){
            // 올바르지 못한 닫힘 기호
            if(next=='(' || next=='['){
                flag=false;
                return -1;
            }
            inner += calc(next);
        }

        // 답을 찾지 못한 채 빈 stack
        if(next!=c){
            flag=false;
            return -1;
        }

        if(inner==0){ return points; }
        return points*inner;
    }
}
