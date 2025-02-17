import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int switch_N = Integer.parseInt(br.readLine()); // 스위치 수
        int[] state = new int[switch_N]; // 스위치 상태

        String[] input = br.readLine().split(" ");
        for(int i=0; i<switch_N; i++)
            state[i] = Integer.parseInt(input[i]);
        
        int student_N = Integer.parseInt(br.readLine()); // 학생 수

        for(int i=0; i<student_N; i++){
            input = br.readLine().split(" ");
            int gender = Integer.parseInt(input[0]);
            int num = Integer.parseInt(input[1]);

            if(gender == 1){
                for(int j=(num-1); j<switch_N; j+=num)
                    state[j] = (state[j]==1)?0:1;
            }else{
                int j = num-1;
                int left = j-1;
                int right = j+1;
                state[j] = (state[j]==1)?0:1;
                while(left>=0 && right<switch_N){
                    if(state[left] == state[right]){
                        state[left] = (state[left]==1)?0:1;
                        state[right] = (state[right]==1)?0:1;
                        left--;
                        right++;
                    }else break;
                }
            }
        }

        for(int i=0; i<switch_N; i++){
            bw.write(String.valueOf(state[i]));
            if(i < switch_N - 1) bw.write(" ");
            if(((i+1)%20)== 0) bw.newLine();
        }
        
        
        bw.newLine();
        bw.flush();
        
        br.close();
        bw.close();

    }
}
