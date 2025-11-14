import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[] req = new int[N];
        int low=0, high=-1;
        
        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            req[i] = Integer.parseInt(input[i]);
            if(req[i]>high){
                high = req[i];
            }
        }

        int M = Integer.parseInt(br.readLine());
        int mid=0, total=0;
        while(low<=high){
            mid = (low+high)/2;
            total =0;
            for(int i=0; i<N; i++){
                total += Math.min(req[i], mid);
            }
            if(total<=M){
                low = mid+1;
            } else{
                high = mid-1;
            }
        }
        bw.write(high+"\n");
        bw.flush();

        br.close();
        bw.close();
    }
}
