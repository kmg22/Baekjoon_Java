import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N;
    private static long[] fac;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        
        factorial();
        
        switch(input[0]){
            case "1":
                List<Integer> num = solve1(input);
                for(int e : num){
                    bw.write(e+" ");
                }
                break;
            case "2":
                long result = solve2(input);
                bw.write(result+"\n");
                break;
        }

        bw.flush();
        br.close();
        bw.close();
    }
    
    private static List<Integer> solve1(String[] input){
        List<Integer> num = new ArrayList<>();
        long K = Long.parseLong(input[1]);
        boolean[] visited = new boolean[N+1];
        
        for(int i=0; i<N; i++){
            for(int j=1; j<=N; j++){
                if(visited[j]){ continue; }

                if(K > fac[N-i-1]){
                    K -= fac[N-i-1];
                }else{
                    num.add(j);
                    visited[j]=true;
                    break;
                }
            }
        }
        return num;
    }

    private static long solve2(String[] input){
        int[] num = new int[N];
        boolean[] visited = new boolean[N+1];
        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(input[i+1]);
        }

        long cnt=1;
        for(int i=0; i<N; i++){
            for(int j=1; j<num[i]; j++){
                if(!visited[j]){
                    cnt += fac[N-i-1];
                }
            }
            visited[num[i]]=true;
        }
        return cnt;
    }

    private static void factorial(){
        fac = new long[21];
        fac[0]=1;
        for(int i=1; i<21; i++){
            fac[i] = i*fac[i-1];
        }
    }
}
