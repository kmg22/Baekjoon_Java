// [silver4] 올바른 배열 | 1337
// https://www.acmicpc.net/problem/1337
import java.util.Scanner;

public class baekjoon_1337 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        int[] nums = new int[N];
        for(int i=0; i<N; i++)
            nums[i] = scan.nextInt();

        // 오름차순으로 정렬
        for(int i=0; i<N-1; i++){
            for(int j=i+1; j<N; j++){
                if (nums[i] > nums[j]){
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }

//        for(int num : nums)
//            System.out.println(num);
        int continuity = 1; // 연속되는 숫자 개수
        int check = nums[0];
        int highcon = 1; // continuity가 가장 높은 값
        for(int i=1; i<N; i++){
            if(++check == nums[i])
                continuity++;
            else{
                for(int tmp = continuity, k = i; tmp<5; tmp++){
                    if(check++ == nums[k]) {
                        continuity++;
                        k++;
                    }

                    if(highcon < continuity) // highcon 갱신
                        highcon = continuity;
                }

                continuity = 1;
                check = nums[i];
            }

            if(highcon < continuity) // highcon 갱신
                highcon = continuity;

            if(highcon >= 5)
                break;
        }

        System.out.println(5-highcon);
    }
}