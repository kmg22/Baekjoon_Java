import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N=9;
    private static int[][] board;
    private static List<int[]> zero;
    private static boolean flag;
    
    public static void main(String[] args) throws Exception {
        board = new int[N][N];
        zero = new ArrayList<>();

        String[] input;
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                board[i][j] = Integer.parseInt(input[j]);
                if(board[i][j]==0){
                    zero.add(new int[]{i, j});
                }
            }
        }
        
        bakctracking(0);

        bw.flush();
        br.close();
        bw.close();
    }

    private static void bakctracking(int idx) throws Exception{
        if(flag){ return; }

        if(idx==zero.size()){
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    bw.write(board[i][j]+" ");
                }
                bw.newLine();
            }
            flag=true;
            return;
        }

        int[] tmp = zero.get(idx);
        for(int i=1; i<=N; i++){
            // 일직선 검사
            boolean check1=false;
            for(int j=0; j<N; j++){
                if(board[tmp[0]][j]==i || board[j][tmp[1]]==i){
                    check1=true;
                    break; 
                }
            }
            if(check1){ continue; }

            // 3*3 검사
            int x = (tmp[0]/3)*3;
            int y = (tmp[1]/3)*3;
            if(board[x][y]==i || board[x][y+1]==i || board[x][y+2]==i){ continue; }
            if(board[x+1][y]==i || board[x+1][y+1]==i || board[x+1][y+2]==i){ continue; }
            if(board[x+2][y]==i || board[x+2][y+1]==i || board[x+2][y+2]==i){ continue; }
            
            board[tmp[0]][tmp[1]]=i;
            bakctracking(idx+1);
            if(flag){ return; }
            board[tmp[0]][tmp[1]]=0;
        }
    }
}
