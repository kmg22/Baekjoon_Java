// [level2] 통계학 | 2108

import java.util.Scanner;

public class baekjoon_2108 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int[] nums = new int[8001]; // -4000~4000 -> 0~8000

        int max = Integer.MIN_VALUE; // 최댓값
        int min = Integer.MAX_VALUE; // 최솟값
        int sum = 0;

        int mid = 10000; // 중앙값
        int mod = 10000; // 최빈값

        for(int i=0; i<N; i++){
            int value = scan.nextInt();
            sum += value;
            nums[value+4000]++; // 입력과 동시에 정렬

            if(value > max)
                max = value;
            if(value < min)
                min = value;
        }

        int cnt = 0; // 중앙값 빈도 누적 수
        int mod_max = 0; // 최빈값의 최댓값

        boolean flag = false; // 이전의 동일한 최빈값이 한 번만 등장 -> true

        for(int i=min+4000; i<=max+4000; i++){
            if(nums[i]>0){

                if(cnt < (N+1)/2){
                    // 누적 횟수가 전체 길이 절반에 못 미치면
                    cnt += nums[i]; // i값의 빈도수를 cnt에 누적
                    mid = i-4000; // 중앙값 찾기
                }

                if(mod_max < nums[i]){
                    // 이전 최빈값보다 현재 값의 빈도가 높은 경우
                    mod_max = nums[i];
                    mod = i-4000; // 최빈값 찾기
                    flag = true;  // 첫 등장 -> true
                }
                else if(mod_max == nums[i] && flag==true){
                    // 이전 최빈값 최댓값과 동일하면서 한 번만 중복
                    mod = i-4000;
                    flag = false;
                }
            }
        }

        System.out.println((int)Math.round((double)sum/N)); // 산술평균
        System.out.println(mid); // 중앙값
        System.out.println(mod); // 최빈값
        System.out.println(max-min); // 범위

    }
}
/*
산술평균 : N개의 수들의 합을 N으로 나눈 값
중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
최빈값 : N개의 수들 중 가장 많이 나타나는 값
범위 : N개의 수들 중 최댓값과 최솟값의 차이
 */