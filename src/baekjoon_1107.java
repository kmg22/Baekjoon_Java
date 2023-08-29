// [gold5] 리모컨 | 1107

import java.util.Scanner;

public class baekjoon_1107 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt(); // 이동하려는 채널
        int M = scan.nextInt(); // 고장난 버튼 개수 0~10

        boolean[] broken = new boolean[10]; // 고장난 버튼 0~9
        for(int i=0; i<M; i++) {
            int wow = scan.nextInt();
            broken[wow] = true;
        }

        int cnt = Math.abs(N-100); // 절댓값 +구함 => 최악의 경우 : (+/-)만 계속 누르기
        for(int i=0; i<=999999; i++){ // 누를 수 있는 번호 경우의 수
            String str = String.valueOf(i);
            int len = str.length();

            boolean isBreak = false;
            for(int j=0; j<len; j++){
                if(broken[str.charAt(j)-'0']){ // 고장난 버튼 누름 -> 한 번에 이동할 수 없는 번호
                    isBreak = true;
                    break;
                }
            }
            if(!isBreak){ // i 누를 때 고장난 버튼 안 누르면
                int min = Math.abs(N-i) + len; // i 누른 후(len) N까지 이동하는 횟수(N-i)
                cnt = Math.min(min, cnt);
            }
        }
        System.out.println(cnt);
    }
}
