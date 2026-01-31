// [자료구조] 고무오리 디버깅 | 20001

import java.util.Scanner;

public class baekjoon_20001 {
    public static void main(String[] args) {
        int problems = 0;

        Scanner scan = new Scanner(System.in);
        while(true){
            String word = scan.nextLine();

            if(word.equals("고무오리 디버깅 끝"))
                break;

            switch (word) {
                case "고무오리":
                    if(problems==0) problems += 2;
                    else problems--;
                    break;
                case "문제":
                    problems++;
                    break;
                default:
                    break;
            }
        }

        if (problems==0)
            System.out.print("고무오리야 사랑해");
        else
            System.out.println("힝구");
    }
}