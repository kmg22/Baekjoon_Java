// [level2] 좌표정렬하기 | 11650

import java.util.Arrays;
import java.util.Scanner;

public class baekjoon_11650 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int nums = scan.nextInt();
        int[][] xy = new int[nums][2];

        for(int i=0; i<nums; i++){
            xy[i][0] = scan.nextInt(); // X좌표
            xy[i][1] = scan.nextInt(); // Y좌표
        }

        // 방안3) Array.sort 알고리즘 사용
        Arrays.sort(xy, (e1, e2)->{
            if(e1[0] == e2[0]){
                return e1[1] - e2[1];
            }else{
                return e1[0] - e2[0];
            }
        });

        for(int i=0; i<nums; i++){
            System.out.println(xy[i][0] + " " + xy[i][1]);
        }
    }
}

// 방법1) 시간복잡도 O(N^2) 버블정렬
/*
        for(int j=0; j<(nums-1); j++){
            for(int i=0; i<(nums-1-j); i++) {
                if (xy[i][0] > xy[i + 1][0]) {
                    int tmpx, tmpy = 0;
                    tmpx = xy[i][0];
                    tmpy = xy[i][1];

                    xy[i][0] = xy[i + 1][0];
                    xy[i][1] = xy[i + 1][1];

                    xy[i + 1][0] = tmpx;
                    xy[i + 1][1] = tmpy;
                } else if (xy[i][0] == xy[i + 1][0]) {
                    if (xy[i][1] > xy[i + 1][1]) {
                        int tmpx, tmpy = 0;
                        tmpx = xy[i][0];
                        tmpy = xy[i][1];

                        xy[i][0] = xy[i + 1][0];
                        xy[i][1] = xy[i + 1][1];

                        xy[i + 1][0] = tmpx;
                        xy[i + 1][1] = tmpy;
                    }
                }
            }
        }
 */


// 방법2) 시간복잡도 O(N^2) 퀵정렬
/*
    private static void l_pivot_sort(int[][] a, int lo, int hi){
        if(lo >= hi){
            return;
        }
        int pivot = partition(a, lo, hi);
        l_pivot_sort(a, lo, pivot-1);
        l_pivot_sort(a, pivot+1, hi);
    }

    private static int partition(int[][] a, int left, int right){
        int lo = left;
        int hi = right;
        int pivot_x = a[left][0];
        int pivot_y = a[left][1];

        while(lo < hi) {
            while(a[hi][0]>=pivot_x && a[hi][1]>pivot_y && lo<hi) hi--;
            while (a[lo][0]<=pivot_x && lo < hi) lo++;
            swap(a, lo, hi);
        }
        swap(a,left, lo);
        return lo;
    }

    private static void swap(int[][] xy, int i, int j){
        int tmpx, tmpy = 0;
        tmpx = xy[i][0];
        tmpy = xy[i][1];

        xy[i][0] = xy[j][0];
        xy[i][1] = xy[j][1];

        xy[j][0] = tmpx;
        xy[j][1] = tmpy;
    }
 */