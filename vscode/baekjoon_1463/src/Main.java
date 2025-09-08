import java.util.Scanner;

public class Main {
    static int count[];

    public static int DP(int n){
        if(n<=3){
            return count[n];
        }

        for(int i=4; i<=n; i++){
            if(i%2==0 && i%3==0){
                count[i] = count[i/2]<count[i/3]? count[i/2]+1 : count[i/3]+1;
            }else if(i%2==0){
                count[i] = count[i-1]<count[i/2]? count[i-1]+1 : count[i/2]+1;
            }else if(i%3==0){
                count[i] = count[i-1]<count[i/3]? count[i-1]+1 : count[i/3]+1;
            }else{
                count[i] = count[i-1]+1;
            }
        }
        return count[n];
        
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        count = new int[N+1];

        count[1] = 0;
        if(N>1) count[2] = 1;
        if(N>2) count[3] = 1;
        
        int out = DP(N);

        System.out.println(out);
    }
}
