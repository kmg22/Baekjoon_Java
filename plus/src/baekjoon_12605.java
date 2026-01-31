// [자료구조] 단어순서 뒤집기 | 12605

import java.util.Scanner;

public class baekjoon_12605 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();
        String[] dic = new String[num+1];
        scan.nextLine();

        for(int i=1; i<=num; i++) {
            String str = scan.nextLine();
            String rev_words = "";

            String[] words = str.split(" ");

            for(int j=words.length-1; j>=0 ; j--){
                rev_words += words[j];
                rev_words += " ";
            }
            dic[i] = rev_words;
        }

        for (int i = 1; i <= num; i++) {
            System.out.print("Case #" + i + ": ");
            System.out.println(dic[i]);
        }
    }
}