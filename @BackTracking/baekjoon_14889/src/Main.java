import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, result=Integer.MAX_VALUE;
    private static int[][] S;
    private static int[] whereTeam;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        S = new int[N][N];
        whereTeam = new int[N];

        String[] input;
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                S[i][j] = Integer.parseInt(input[j]);
            }
        }

        whereTeam[0] = 1;
        BackTracking(1, 0, 0, 1, 0);
        
        bw.write(result+"\n");
        bw.flush();
        br.close();
        bw.close();
    }

    private static void BackTracking(int idx, int startS, int linkS, int startCnt, int linkCnt){
        // 한 팀이라도 기준 인원 초과 시 리턴
        if(startCnt>(N/2) || linkCnt>(N/2)){ return; }
        
        // 모든 인원 배정
        if(idx==N){
            result = Math.min(result, Math.abs(startS-linkS));
            return;
        }

        // idx번을 start(1)팀 배정
        whereTeam[idx] = 1;
        int sum=calc(idx, 1);
        BackTracking(idx+1, startS+sum, linkS, startCnt+1, linkCnt);
         
        // idx번을 link(2)팀 배정
        whereTeam[idx] = 2;
        sum=calc(idx, 2);
        BackTracking(idx+1, startS, linkS+sum, startCnt, linkCnt+1);

        whereTeam[idx] = 0;

    }

    private static int calc(int idx, int team){
        int sum=0;
        for(int i=0; i<idx; i++){
            if(whereTeam[i]==team){
                sum += S[i][idx];
                sum += S[idx][i];
            }
        }
        return sum;
    }
}
