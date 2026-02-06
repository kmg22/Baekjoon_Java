import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringBuilder sb = new StringBuilder();
    private static Stack<Character> stack = new Stack<>();
    private static String input;

    public static void main(String[] args) throws Exception {
        input = br.readLine();
        
        for(int i=0; i<input.length(); i++){
            char tmp = input.charAt(i);

            switch(tmp){
                case '+':
                case '-':
                case '*':
                case '/':
                    // 우선순위 같거나 높은 연산자가 남아 있으면 flush
                    while(!stack.isEmpty() && priority(tmp)<=priority(stack.peek())){
                        sb.append(stack.pop());
                    }
                    stack.push(tmp);
                    break;
                
                case '(':
                    stack.push(tmp);
                    break;
                case ')':
                    char next;
                    while(!stack.isEmpty() && (next=stack.pop())!='('){
                        sb.append(next);
                    }
                    break;
                
                default :
                    sb.append(tmp);
                    break;
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        bw.write(sb.toString()+"\n");

        bw.flush();
        br.close();
        bw.close();
    }
    
    private static int priority(char c){
        if(c=='*' || c=='/'){ return 2; }
        if(c=='+' || c=='-'){ return 1; }
        return 0;
    }

}
