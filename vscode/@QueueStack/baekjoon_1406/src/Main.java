import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        Stack<String> leftStack = new Stack<String>();
        Stack<String> rightStack = new Stack<String>();

        String[] input = br.readLine().split("");
        for(String s : input){
            leftStack.push(s);
        }

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            String[] command = br.readLine().split("");
            switch(command[0]){
                case "L":
                    if(!leftStack.isEmpty()){
                        rightStack.push(leftStack.pop());
                    }
                    break;
                case "D":
                    if(!rightStack.isEmpty()){
                        leftStack.push(rightStack.pop());
                    }
                    break;
                case "B":
                    if(!leftStack.isEmpty()){
                        leftStack.pop();
                    }
                    break;
                case "P":
                    leftStack.push(command[2]);
                    break;
            }
        }

        while(!leftStack.isEmpty()){
            rightStack.push(leftStack.pop());
        }
        while(!rightStack.isEmpty()){
            bw.write(rightStack.pop());
        }


        bw.flush();
        br.close();
        bw.close();
    }
}
