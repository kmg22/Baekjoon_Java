// [level2] 설탕배달 | 2839

import java.util.Scanner;

public class baekjoon_2839 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sugar = scan.nextInt();
        int bag = 0;

        bag += sugar / 5;
        sugar = sugar % 5;

        if((bag!=0&&sugar==1) || (bag!=0&&sugar==4)) {
            bag--;
            sugar += 5;
        }
        else if((bag>=2&&sugar==2)){
            bag -= 2;
            sugar += 10;
        }

        bag += sugar / 3;
        sugar = sugar % 3;

        if(sugar!=0){
            bag = -1;
        }

        System.out.println(bag);
    }
}