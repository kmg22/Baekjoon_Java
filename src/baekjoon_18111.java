// [level2] 마인크래프트 | 18111

import java.util.Scanner;

public class baekjoon_18111 {
    private static int install(int[][] minecraft, int max){
        int need = 0;
        return need;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt(); // 행
        int M = scan.nextInt(); // 열
        int B = scan.nextInt(); // 인벤토리 블록 수

        int max = 0; // 최대 블록 높이
        int need = 0; // 평탄화(최대 블록 높이로 동기화) 위해 필요한 블록 개수

        int[][] minecraft = new int[N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++) {
                minecraft[i][j] = scan.nextInt();

                if(minecraft[i][j] > max)
                    max = minecraft[i][j];
            }
        }

        if(need > B){

        }
    }
}
/*
블록 2개 설치 = 블록 1개 파괴
블록 2높이 설치 = 블록 1 높이 파괴
1. 최대 높이로 채우기 위한 시간 파악
2. 블록 개수 모자르면 그만큼 블록 캐기

1 0 5 6
5 9 5 7
2 5 4 3
 */