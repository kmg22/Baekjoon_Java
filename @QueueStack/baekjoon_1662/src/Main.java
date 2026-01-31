import java.io.*;
import java.util.*;


public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws Exception {
        String input = br.readLine();
        for(int i=0; i<input.length(); i++){
            stack.push(input.charAt(i));
        }

        int result = count();
        
        bw.write(result+"\n");
        bw.flush();
        br.close();
        bw.close();
    }

    private static int count(){
        int cnt=0;
        while(!stack.isEmpty()){
            int cur = stack.pop();
            switch(cur){
                case ')':
                    int num = count();
                    cnt += Character.getNumericValue(stack.pop())*num;
                    break;
                case '(':
                    return cnt;
                default : 
                    cnt++;
                    break;
            }
        }
        return cnt;
    }
}
