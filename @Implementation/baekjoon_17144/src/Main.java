import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int R, C, T, idx=0, micro, tmpr, tmpc, cnt, result=0, k;
    private static String[] input;
    private static int[][] A, backup, effect;
    private static int[] machine;
    private static int[] dr = {0, -1, 0, 1}; // 우 | 상 | 좌 | 하
    private static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        T = Integer.parseInt(input[2]);

        A = new int[R][C];
        backup = new int[R][C];
        machine = new int[2];
        for(int i=0; i<R; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<C; j++){
                A[i][j] = Integer.parseInt(input[j]);
                if(j==0 && A[i][j]==-1){machine[idx++]=i;}
            }
        }

        while(T-- > 0){
            dustSpread();
            airCircle();
        }

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(A[i][j]==-1){continue; }
                result += A[i][j];
            }
        }

        bw.write(result+"\n");
        bw.flush();
        br.close();
        bw.close();
    }

    private static void dustSpread(){
        effect = new int[R][C];
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(A[i][j]>=5){
                    micro = A[i][j]/5;
                    cnt=0;
                    for(int k=0; k<4; k++){
                        tmpr = i + dr[k];
                        tmpc = j + dc[k];
                        if(tmpr<0 || tmpr>=R || tmpc<0 || tmpc>=C || A[tmpr][tmpc]<=-1){ continue; }
                        cnt++;
                        effect[tmpr][tmpc] += micro;
                    }
                    A[i][j] -= micro*cnt;
                }
            }
        }

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                A[i][j] += effect[i][j];
            }
        }
    }

    private static void airCircle(){
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                backup[i][j] = A[i][j];
            }
        }

        // top
        tmpr = machine[0];
        tmpc = 1;
        k = 0;
        while(k<4){
            tmpr += dr[k];
            tmpc += dc[k];
            if(tmpr==machine[0] && tmpc==0){break;}
            A[tmpr][tmpc] = backup[tmpr-dr[k]][tmpc-dc[k]];
            if((tmpr==0&&tmpc==0) || (tmpr==0&&tmpc==C-1) || (tmpr==machine[0]&&tmpc==C-1)){ k++; }
        }
        // down
        tmpr = machine[1];
        tmpc = 1;
        k=0;
        while(k<4){
            tmpr += dr[k];
            tmpc += dc[k];
            if(tmpr==machine[1] && tmpc==0){break;}
            A[tmpr][tmpc] = backup[tmpr-dr[k]][tmpc-dc[k]];
            if((tmpr==R-1&&tmpc==0) || (tmpr==R-1&&tmpc==C-1) || (tmpr==machine[1]&&tmpc==C-1)){ k = (k+3)%4; }
        }

        A[machine[0]][1] = 0;
        A[machine[1]][1] = 0;

    }
}
