import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] alias = new String[N];
        int[] max = new int[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            alias[i] = st.nextToken();
            max[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<M; i++){
            int num = Integer.parseInt(br.readLine());

            // 이진 탐색
            int left=0;
            int right=N;
            int index=0;

            while(left<=right){
                int mid = (left+right)/2;
                if(num <= max[mid]){
                    right = mid-1;
                    index = mid;
                }else if(num > max[mid]){
                    left = mid+1;
                }
            }
            bw.write(alias[index]+"\n");
        }


        bw.newLine();
        bw.flush();

        br.close();
        bw.close();
    }
}
