import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int X = Integer.parseInt(input[1]);

        int[] visitor = new int[N];

        input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            visitor[i] = Integer.parseInt(input[i]); 
        }

        int sum=0;
        for(int i=0; i<X; i++){
            sum += visitor[i];
        }

        int max=sum, days=1;
        for(int i=0; i<(N-X); i++){
            sum -= visitor[i];
            sum += visitor[i+X];

            if(max < sum){
                max = sum;
                days=1;
            }
            else if(max == sum){
                days++;
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
