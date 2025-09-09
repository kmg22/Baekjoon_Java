import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws Exception {
        Scanner scaner = new Scanner(System.in);
        int N = scaner.nextInt();
        int M = scaner.nextInt();

        int[] pkgs = new int[M];
        int[] pcs = new int[M];

        for(int i=0; i<M; i++){
            pkgs[i] = scaner.nextInt();
            pcs[i] = scaner.nextInt();
        }

        int bestpc = Integer.MAX_VALUE;
        int bestpkg = Integer.MAX_VALUE;
        for(int pc : pcs){
            if(pc<bestpc){
                bestpc = pc;
            }
        }

        for(int pkg : pkgs){
            if(pkg<bestpkg){
                bestpkg = pkg;
            }
        }

        int out = 0;
        if(bestpkg/6 >= bestpc){
            out = N * bestpc;
        }else{
            int out1 = (N/6) * bestpkg + (N%6) * bestpc;
            int out2 = (N/6 + 1) * bestpkg;
            out = Math.min(out1, out2);
        }

        System.out.println(out);
    }
}
