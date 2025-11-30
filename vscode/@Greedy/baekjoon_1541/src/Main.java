import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        String[] op = br.readLine().split("-");
        int sum=0;

        for(int i=0; i<op.length; i++){
            int tmp=0;

            String[] sub_op = op[i].split("\\+");
            for(int j=0; j<sub_op.length; j++){
                tmp += Integer.parseInt(sub_op[j]);
            }

            if(i==0){
                sum = tmp;
            }else{
                sum -= tmp;
            }
        }
        bw.write(sum+"\n");
        bw.flush();
        
        br.close();
        bw.close();
    }
}
