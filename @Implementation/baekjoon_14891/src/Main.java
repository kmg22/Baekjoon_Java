import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int K, num, rot, left, right;
    private static int[][] cw = new int[4][8];
    private static int[] twelve = new int[4]; // 초기 12시 idx는 0
    private static int[] dir;
    private static String[] input;

    public static void main(String[] args) throws Exception {
        // 톱니바퀴 정보 (N:0 | S:1)
        for(int i=0; i<4; i++){
            input = br.readLine().split("");
            for(int j=0; j<8; j++){
                cw[i][j] = Integer.parseInt(input[j]);
            }
        }
        // 회전
        K = Integer.parseInt(br.readLine()); 
        while(K-->0){
            input = br.readLine().split(" ");
            num = Integer.parseInt(input[0])-1; // 시작 톱니 번호
            rot = Integer.parseInt(input[1]); // 회전 방향
            rot = rot==1?7:1;
            dir = new int[4];
            rotation();
        }

        bw.write(calc()+"\n");    
        bw.flush();
        br.close();
        bw.close();
    }

    private static void rotation(){
        dir[num] = rot;

        // 왼쪽
        for(int i=num-1; i>=0; i--){
            left = (twelve[i]+2)%8;
            right = (twelve[i+1]+6)%8;

            if(cw[i][left]!=cw[i+1][right]){
                dir[i] = dir[i+1]==1?7:1;
            }else{ break; }
        }

        // 오른쪽
        for(int i=num+1; i<4; i++){
            left = (twelve[i-1]+2)%8;
            right = (twelve[i]+6)%8;

            if(cw[i-1][left]!=cw[i][right]){
                dir[i] = dir[i-1]==1?7:1;
            }else{ break; }
        }

        for(int i=0; i<4; i++){
            twelve[i] = (twelve[i]+dir[i])%8;

        }
    }

    private static int calc(){
        int sum=0;
        sum += cw[0][twelve[0]]==0?0:1;
        sum += cw[1][twelve[1]]==0?0:2;
        sum += cw[2][twelve[2]]==0?0:4;
        sum += cw[3][twelve[3]]==0?0:8;
        return sum;
    }
}
