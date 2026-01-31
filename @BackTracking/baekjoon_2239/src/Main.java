import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[][] puzzle = new int[9][9];
    private static List<int[]> blank = new ArrayList<>();
    private static boolean flag;

    public static void main(String[] args) throws Exception {
        String[] input;
        for(int i=0; i<9; i++){
            input = br.readLine().split("");
            for(int j=0; j<9; j++){
                puzzle[i][j] = Integer.parseInt(input[j]);
                if(puzzle[i][j]==0){ blank.add(new int[] {i, j}); }
            }
        }

        backtracking(0);

        bw.flush();
        br.close();
        bw.close();
    }

    private static void backtracking(int idx) throws Exception{
        if(flag){ return; }

        if(idx==blank.size()){
            for(int i=0; i<9; i++){
                for(int j=0; j<9; j++){
                    bw.write(puzzle[i][j]+"");
                }
                bw.newLine();
            }
            flag = true;
            return;
        }

        int[] tmp = blank.get(idx);
        for(int i=1; i<=9; i++){
            puzzle[tmp[0]][tmp[1]] = i;
            if(lineCheck(tmp[0], tmp[1]) && cubeCheck(tmp[0], tmp[1])){
                backtracking(idx+1);
            }
            if(flag){ return; }
            puzzle[tmp[0]][tmp[1]] = 0;
        }

    }

    private static boolean lineCheck(int row, int column){
        for(int i=0; i<9; i++){
            if(puzzle[row][column]==puzzle[i][column] && row!=i){ return false; }
            if(puzzle[row][column]==puzzle[row][i] && column!=i){ return false; }
        }
        return true;
    }

    private static boolean cubeCheck(int row, int column){
        for(int i=(row/3)*3; i<(row/3)*3+3; i++){
            for(int j=(column/3)*3; j<(column/3)*3+3; j++){
                if(i==row && j==column){ continue; }
                if(puzzle[i][j]==puzzle[row][column]){ return false; }
            }
        }
        return true;
    }
}
