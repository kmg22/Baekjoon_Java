// [level2] 체스판 다시 칠하기 | 1018

import java.util.Scanner;

public class baekjoon_1018 {
    private static int find(boolean[][] board, int n, int m){
        boolean square = board[n][m];
        int cnt = 0;

        for(int i=n; i<n+8; i++) {
            for (int j=m; j<m+8; j++) {
                if(board[i][j] != square)
                    cnt++;
                square = (!square); // 다음 칸의 예정 색으로 기준이 바뀜
            }
            square = (!square);
        }

        // 스타트 자체부터 바꾸는 방법
        if(cnt > 32)
            cnt = 64-cnt;

        return cnt;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt(); // 행 개수
        int M = scan.nextInt(); // 열 개수

        int coloring = 64; // 최악의 경우로 기본 세팅

        boolean[][] board = new boolean[N][M];

        // 입력받기
        for(int n=0; n<N; n++){
            String str = scan.next();

            for(int m=0; m<M; m++){
                char chr = str.charAt(m);
                if(chr == 'W')
                    board[n][m] = true; // W는 true(1)로 처리
                else if(chr == 'B')
                    board[n][m] = false; // B는 false(0)로 처리
            }
        }

        // 8x8 바둑판이 나오는 경우
        for(int n=0; n<N-7; n++){
            for(int m=0; m<M-7; m++){
                // 다시 칠해야 하는 칸 개수
                int num = find(board, n, m);

                if(coloring > num)
                    coloring = num;
            }
        }

        System.out.println(coloring);

    }
}