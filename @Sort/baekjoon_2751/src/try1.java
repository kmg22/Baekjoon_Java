/*
 * 버블 정렬 방식으로 풀이. 그러나 시간 초과 오류 발생
 *  O(n^2) 시간복잡도
 */

import java.util.Scanner;

public class try1 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int N = 1000000;
        N = scanner.nextInt();
        int[] nums = new int[N];

        for(int i=0; i<N; i++)
            nums[i] = scanner.nextInt();

        for(int i=0; i<N-1; i++)
            for(int j=0; j<N-i-1; j++)
                if(nums[j] > nums[j+1]){
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }

        for(int i=0; i<N; i++)
            System.out.println(nums[i]);
        
        scanner.close();    
    }
}
