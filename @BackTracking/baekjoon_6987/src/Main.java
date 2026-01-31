import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[][] score, match;
    private static String[] input;
    private static int result;
    private static boolean flag;

    public static void main(String[] args) throws Exception {
        score = new int[6][3];
        match = new int[15][2];

        // 대진표 작성
        /*  A - B C D E F
            B - C D E F
            C - D E F
            D - E F
            E - F
        */
        int idx=0;
        for(int i=0; i<5; i++){
            for(int j=i+1; j<6; j++){
                match[idx][0]=i;
                match[idx][1]=j;
                idx++;
            }
        }

        for(int t=0; t<4; t++){
            flag=true;
            result=0;

            input = br.readLine().split(" ");
            for(int i=0; i<18; i++){
                score[i/3][i%3] = Integer.parseInt(input[i]);
            }

            // 각 나라 별 경기 수 검사
            for(int i=0; i<6; i++){
                if(score[i][0]+score[i][1]+score[i][2] != 5){
                    flag = false;
                }
            }

            if(flag){
                backtracking(0);
            }
            bw.write(result+" ");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static void backtracking(int idx){
        // 모든 경기 정상적
        if(idx==15){
            result = 1;
            return;
        }

        int t1 = match[idx][0];
        int t2 = match[idx][1];

        for(int i=0; i<3; i++){
            int j=2-i;
            if(score[t1][i]>0 && score[t2][j]>0){
                score[t1][i]--;
                score[t2][j]--;
                backtracking(idx+1);
                score[t1][i]++;
                score[t2][j]++;
            }
            if(result==1){ return; }
        }
    }
}
