// [silver1] 동물원 | 1309

import java.util.Scanner;

public class baekjoon_1309 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int[][] zoo = new int[N+1][3];

        // zoo[N][0] : N번 째 줄에 아무것도 없는 경우
        // zoo[N][1] : N번 째 줄에 첫번 째 칸에 놓는 경우
        // zoo[N][2] : N번 째 줄에 두번 째 칸에 놓는 경우

        zoo[1][0] = zoo[1][1] = zoo[1][2] = 1;
        for(int i=2; i<=N; i++){
            zoo[i][0] = (zoo[i-1][0] + zoo[i-1][1] + zoo[i-1][2]) % 9901;
            // i번 째 줄에는 사자 없음 -> 이전 방(i-1)에서 사자 어디 있었든 상관 없음
            zoo[i][1] = (zoo[i-1][0] + zoo[i-1][2]) % 9901;
            // i번 째 줄 첫 번째 칸에 사자 넣음 -> 이전 방에는 두번 째 칸에 넣거나 사자 없는 경우 가능
            zoo[i][2] = (zoo[i-1][0] + zoo[i-1][1]) % 9901;
            // i번 째 줄 두 번째 칸에 사자 넣음 -> 이전 방에는 첫번 째 칸에 넣거나 사자 없는 경우 가능
        }
        long cnt = zoo[N][0] + zoo[N][1] + zoo[N][2];
        System.out.println(cnt%9901);
    }
}
/*
Dynamic Programming
DP : 동적 계획법
본래의 문제 분석하고 반복되는 연산 찾기
 */