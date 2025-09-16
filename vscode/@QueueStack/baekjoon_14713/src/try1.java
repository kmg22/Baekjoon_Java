// 시간 초과
import java.io.*;
import java.util.*;

public class try1{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Deque<String> deque = new LinkedList<>();
        for(int i=0; i<N; i++){
            String input = br.readLine();
            deque.addLast(input);
        }

        String[] answer = br.readLine().split(" ");
        String[] criteria = deque.peekFirst().split(" ");

        int i=0, check=0;
        while(!deque.isEmpty()){
            String[] current = deque.pollFirst().split(" ");
            if(current[0].equals(criteria[0])){
                check++;
                if(check>=2) break;
            }

            StringBuilder sb = new StringBuilder();
            boolean pass=false;
            int cnt=0;
            for(String s : current){
                if(pass || i >= answer.length || !s.equals(answer[i])){
                    pass=true;
                    sb.append(s+" ");
                    cnt++;
                }else{
                    i++;
                }
            }
            if(cnt>0){
                String str = sb.toString();
                deque.addLast(str);
                if(cnt!=current.length) {
                    criteria = deque.peekFirst().split(" ");
                    check=0;
                }
            }else{
                if(!deque.isEmpty()) {
                    criteria = deque.peekFirst().split(" ");
                    check=0;
                }
            }
        }

        if(check>=2 || (i < answer.length && deque.isEmpty())){
            bw.write("Impossible");
        }else{
            bw.write("Possible");
        }
        
        bw.flush();

        br.close();
        bw.close();
    }
}
