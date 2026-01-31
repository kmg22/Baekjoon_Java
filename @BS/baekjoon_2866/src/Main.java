import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        String[] input = br.readLine().split(" ");
        int R = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);
        int low=0, high=R-1;

        char[][] table = new char[R][C];
        for(int r=0; r<R; r++){
            input = br.readLine().split("");
            for(int c=0; c<C; c++){
                table[r][c] = input[c].charAt(0);
            }   
        }

        while(low<=high){
            int mid = (low+high)/2;

            boolean flag=true;
            HashSet<String> set = new HashSet<>();
            for(int c=0; c<C; c++){
                StringBuilder sb = new StringBuilder();
                for(int r=mid+1; r<R; r++){
                    sb.append(table[r][c]);
                }

                if(set.contains(sb.toString())){
                    flag = false;
                    break;
                }
                set.add(sb.toString());
            }

            if(flag){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        bw.write(low+"\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
