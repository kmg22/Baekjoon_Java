import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int MAX = 101;
        Queue<String>[] q = new LinkedList[MAX];

        for(int i=0; i<MAX; i++){
            q[i] = new LinkedList<String>();
        }

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            for(int j=0; j<input.length; j++){
                q[i].add(input[j]);
            }
        }

        String[] answer = br.readLine().split(" ");
        boolean flag = true;
        for(int i=0; i<answer.length; i++){
            boolean successFlag = false;
            for(int j=0; j<N; j++){
                if(!q[j].isEmpty() && q[j].peek().equals(answer[i])){
                    q[j].poll();
                    successFlag = true;
                    break;
                } 
            }
            if(successFlag == false){
                flag = false;
                break;
            }
        }

        for(int i=0; i<N; i++){
            if(!q[i].isEmpty()){
                flag = false;
                break;
            }
        }
        
        if(flag){
            bw.write("Possible");
        }else{
            bw.write("Impossible");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
