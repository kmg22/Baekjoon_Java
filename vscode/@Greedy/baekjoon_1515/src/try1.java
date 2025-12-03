
import java.util.*;

public class try1 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String nums = scanner.nextLine();

        int top=1;
        int ptr=0;
        for(; top<=30000; top++){ // 3000까지라고 잘못 설정했다가 삽질함..
            String tmp = String.valueOf(top);
            for(int i=0; i<tmp.length(); i++){
                if( tmp.charAt(i) == nums.charAt(ptr)){
                    ptr++;
                }
                if(ptr == nums.length()){
                    System.out.println(top);
                    return;
                }
            }
        }
        scanner.close();
    }
}
