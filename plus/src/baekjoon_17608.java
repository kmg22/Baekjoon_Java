// [자료구조] 막대기 | 17608

import java.util.Scanner;

public class baekjoon_17608 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();
        int[] numbers = new int[num+1];

        for(int i=0 ; i<num ; i++){
            numbers[i+1] = scan.nextInt();
        }

        int cnt=1;
        int max = numbers[num];
        for (int i=num; i>=1 ; i--){
            if(numbers[i] > max) {
                max = numbers[i];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}

/*
주의
중간에 마지막보다 큰 높이의 막대기가 있다면
그 막대기 뒤의 작은 값들은 보이지 않게 됨
 */