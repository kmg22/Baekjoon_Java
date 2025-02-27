import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        
        int N = scan.nextInt();
        int M = scan.nextInt();

        if(N==1)
            System.out.println(1);
        else if(N==2)
            System.out.println(Math.min(4, (M+1)/2));
        else
            if(M<7) System.out.println(Math.min(4, M));
            else System.out.println(M-2);
        
        scan.close();
    }
}
