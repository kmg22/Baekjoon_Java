// [level2] 프린터 큐 | 1966

import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class baekjoon_1966 {

    private static int find(Queue<Integer> queue, int out){
        out++; // 몇 번째로 출력될 것인가..
        int qsize = queue.size();

        for(int i=0; i<qsize; i++){
            int top = i;
            for(int j=0; j<queue.size(); j++){
                int max = queue.peek();
                top = i; // 가장 큰 중요도를 가진 문서 인덱스 위치
                int k=i;
                // 첫 번째 중요도 top 위치 확인
                for(Integer num : queue){
                    if(num > max) {
                        max = num;
                        top = k;
                    }
                    k++;
                }

                // 0 인덱스 이후에 더 큰 중요도 등장
                if(top > i) {
                    if (out == i+1)
                        out = qsize;
                    else out--;

                    int tmp = queue.poll();
                    queue.add(tmp);
                }
                else
                    break;

            }

            queue.poll(); // 맨 앞 원소 제거(프린트 출력)

            if(out == i+1 && out == top+1)
                break;
        }
        return out;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int testcase = scan.nextInt(); // 테스트케이스 개수
        int[] arr = new int[testcase];

        for(int i=0; i<testcase; i++) {
            int num = scan.nextInt(); // 각 테스트케이스의 문서 개수

            int out = scan.nextInt(); // 조사할 문서 위치

            Queue<Integer> queue = new LinkedList<>();
            for(int k=0; k<num; k++)
                queue.add(scan.nextInt());

            out = find(queue, out);
            arr[i] = out;
        }
        for(int out : arr)
            System.out.println(out);
    }
}