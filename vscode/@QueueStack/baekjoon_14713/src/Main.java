import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Deque<String> deque = new LinkedList<>();
        for(int i=0; i<N; i++){
            String input = br.readLine();
            deque = new LinkedList<String>();
            deque.add(input);
        }

        String[] answer = br.readLine().split(" ");
        String[] criteria = deque.peek().split(" ");

        int i=0, check=0;
        while(!deque.isEmpty()){
            String[] current = deque.poll().split(" ");
            if(current[0].equals(criteria[0])){
                check++;
                if(check>=2) break;
            }

            String[] add = new String[10000];
            int x=0;
            for(String s : current){
                if(!s.equals(answer[i])){
                    add[x++] = s;
                }else{
                    i++;
                }
            }
            if(x>0){
                deque.addLast(String.join(" ", add));
            }else{
                criteria = deque.peek().split(" ");
                check=0;
            }


        }

        if(check>=2){
            bw.write("Impossible");
        }else{
            bw.write("Possible");
        }
        
        bw.flush();

        br.close();
        bw.close();
    }
}
