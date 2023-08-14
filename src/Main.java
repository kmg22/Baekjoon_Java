// [level2] 카드2 | 2164

import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

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