import java.io.*;
import java.util.*;
import static java.util.stream.Collectors.toList;


public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int T, N;
    private static char[] op = {' ','+','-'};// {32, 43, 45}; // 공백, + , -

    public static void main(String[] args) throws Exception {
        T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            N = Integer.parseInt(br.readLine());
            
            
            dijkstra(1, "1");
            bw.write("\n");

        }
        
        bw.flush();
        br.close();
        bw.close();
    }

    private static void dijkstra(int idx, String str) throws Exception{
        if(idx==N){
            if(calc(str)){
                bw.write(str+"\n");
            }
            return;
        }

        for(int i=0; i<3; i++){
            dijkstra(idx+1, str+op[i]+(idx+1));
        }
    }

    private static boolean calc(String str){
        str = str.replaceAll(" ", "");
        Iterator<Integer> it = Arrays.stream(str.split("[+,-]"))
                                .map(Integer::parseInt)
                                .collect(toList()).iterator();
        
        int result = it.next();
        for(int i=0; i<str.length(); i++){
            switch(str.charAt(i)){
                case '+':
                    result += it.next();
                    break;
                case '-':
                    result -= it.next();
                    break;
            }
        }

        return result==0;
    }
}
