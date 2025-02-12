// [silver3] 소수구하기 | 1929
// 에라토스테네스의 체 방식

import java.util.Scanner;

public class baekjoon_1929 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int M = scan.nextInt();
        int N = scan.nextInt();

        boolean arr[] = new boolean[N+1];
        arr[0] = arr[1] = true; // 0과 1은 소수에서 제외

        int sqrt =(int)Math.sqrt(N); // 제곱근 구하기
        for(int i=2; i<=sqrt; i++){
            for(int j=2; j<=N/i; j++){
                if(arr[i*j] != true)
                    arr[i*j] = true;
            }
        }
        for(int i=M; i<=N; i++)
            if(arr[i] == false)
                System.out.println(i);
    }
}
/*
소수 : 자기 자신과 1로만 나누어 떨어지는 수
 */

// 아래 방식은 시간 초과!
/*
        for(int m=M; m<=N ; m++){
            boolean isprime = true;
            for(int i=2; i<m; i++){
                if(m%i == 0) { // 나누어 떨어지는 수 등장
                    isprime = false;
                    break;
                }
            }
            if(isprime == true)
                nums.add(m);
        }

        for(; !nums.isEmpty() ;) {
            System.out.println(nums.get(0));
            nums.remove(0);
        }
 */