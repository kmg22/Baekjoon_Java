// 시간 초과

import java.io.*;

public class try1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int X = Integer.parseInt(input[1]);

        int[] visitor = new int[N];
        int max=0, days=1;

        input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            visitor[i] = Integer.parseInt(input[i]); 
        }

        for(int i=0; i<=(N-X); i++){
            int num=0;
            for(int j=i; j<(i+X); j++){
                num += visitor[j];
                if(max < num){
                    max = num;
                    days=1;
                }
                else if(max == num){
                    days++;
                }
            }
        }

        if(max>0){ bw.write(max+"\n"+days);}
        else{ bw.write("SAD"); }
        
        bw.newLine();
        bw.flush();

        br.close();
        bw.close();
    }
}
