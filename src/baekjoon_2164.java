// [level2] 카드2 | 2164

import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class baekjoon_2164 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        Queue<Integer> cardset = new LinkedList<>();

        for(int i=0; i<N; i++)
            cardset.offer(i+1);

        while(cardset.size()>1){
            cardset.poll(); // 맨 앞 카드 버리기

            int tmp = cardset.poll();
            cardset.offer(tmp);
        }
        System.out.println(cardset.poll());
    }
}
/*
1 2 3 4 5 6
  2 3 4 5 6 >> 1
  3 4 5 6 2
    4 5 6 2 >> 3
    5 6 2 4
      6 2 4 >> 5
      2 4 6
        4 6 >> 2
        6 4
          4 >> 6
 */