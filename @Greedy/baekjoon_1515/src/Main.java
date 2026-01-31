
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String nums = scanner.nextLine();

        int top=1;
        int ptr=0;
        while(ptr < nums.length()){
            String tmp = String.valueOf(top);
            for(int i=0; i<tmp.length() && ptr<nums.length(); i++){
                if( tmp.charAt(i) == nums.charAt(ptr)){
                    ptr++;
                }
            }
            top++;
        }
        System.out.println(top-1);
        scanner.close();
    }
}
