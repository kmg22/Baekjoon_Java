// [silver4] 보물 | 1026
// https://www.acmicpc.net/problem/1026
import java.util.Scanner;

public class baekjoon_1026 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        int[] A = new int[N];
        int[] B = new int[N];

        int[] copyB = new int[N];
        int[] BB = new int[N]; // B 배열을 내림차순으로 정리할 때의 인덱스
        for(int i=0; i<N; i++)
            A[i] = scan.nextInt();
        for(int i=0; i<N; i++) {
            B[i] = scan.nextInt();
            copyB[i] = B[i];
            BB[i] = i;
        }

        for(int i=1; i<N; i++){
            for(int j=0; j<N-i; j++){
                if(B[j]<B[j+1]){ // B 배열 내림차순으로 인덱스 정렬
                    int tmp = B[j];
                    B[j] = B[j+1];
                    B[j+1] = tmp;

                    int indextmp = BB[j];
                    BB[j] = BB[j+1];
                    BB[j+1] = indextmp;
                }

                if(A[j]>A[j+1]){ // A 배열 오름차순으로 정렬
                    int tmp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = tmp;
                }
            }
        }

        int sum = 0;
        for(int i=0; i<N; i++) {
            sum+= (A[i] * copyB[BB[i]]);
        }
        System.out.println(sum);
    }
}
/*
입력1 : 숫자 길이
입력2 : A 배열 숫자
입력3 : B 배열 숫자
 */