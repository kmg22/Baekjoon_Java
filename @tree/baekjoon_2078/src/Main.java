import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int A, B, L, R, tmp;

    public static void main(String[] args) throws Exception {
        String[] input = br.readLine().split(" ");
        A = Integer.parseInt(input[0]);
        B = Integer.parseInt(input[1]);

        while(!(A==1 && B==1)){
            if(A>B){
                tmp = (A-1)/B;
                A-=tmp*B;
                L+=tmp;
            }else{
                tmp = (B-1)/A;
                B-=tmp*A;
                R+=tmp;
            }
        }

        bw.write(L+" "+R+"\n");


        
        bw.flush();
        br.close();
        bw.close();
    }
}
