// [silver4] 한수 | 1065
// https://www.acmicpc.net/problem/1065
import java.util.Scanner;

public class baekjoon_1065 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int cnt = 0;

        for(int i=1; i<=N; i++){
            String num = String.valueOf(i);
            int len = num.length();

            if(len < 3) { // 2자리 이내 숫자면 무조건 한수
                cnt++;
                continue;
            }

            int[] n = new int[len]; // 각 자리 숫자 추출하기
            for(int j=0; j<len; j++)
                n[j] = num.charAt(j);

            boolean ishan = true;
            for(int j=1; j<len-1; j++){
                if(n[j]-n[j-1] != n[j+1]-n[j]){ // 한수 아닌 경우
                    ishan = false;
                    break;
                }
            }
            if(ishan == true)
                cnt++;

        }
        System.out.println(cnt);
    }
}