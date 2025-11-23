import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[][] response;
    static String[] request;

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());
        response = new int[N][2];
        request = new String[N];
        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            request[i] = input[0]; // num
            response[i][0] = Integer.parseInt(input[1]); // strike
            response[i][1] = Integer.parseInt(input[2]);  // ball
        }

        int result=0;
        // 가능한 모든 정답 후보 : target
        for(int i=123; i<=987; i++){
            String target = Integer.toString(i);
            // 자릿 수에 0 금지
            if(target.charAt(0)=='0' || target.charAt(1)=='0' || target.charAt(2)=='0'){ continue; }
            // 중복 숫자 금지
            if(target.charAt(0)==target.charAt(1) || target.charAt(1)==target.charAt(2) || target.charAt(0)==target.charAt(2)){ continue; }

            if(check(target)){
                result++;
            }
        }
        bw.write(result+"\n");
        bw.flush();

        br.close();
        bw.close();
    }

    static boolean check(String target){
        boolean flag=true;
        for(int i=0; i<N; i++){
            String num = request[i];
            int strike=0, ball=0;

            for(int j=0; j<3; j++){
                // check strike
                if(target.charAt(j)==num.charAt(j)){
                    strike++;
                }

                // check ball
                int idx = (j+1)%3;
                if(target.charAt(j)==num.charAt(idx)){
                    ball++;
                }
                idx = (j+2)%3;
                if(target.charAt(j)==num.charAt(idx)){
                    ball++;
                }
            }
            if(strike!=response[i][0] || ball!=response[i][1]){ 
                flag=false;
                break;
            }
        }
        return flag;
    }

}
