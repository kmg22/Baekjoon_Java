import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        String[] input = br.readLine().split(" ");
        int X = Integer.parseInt(input[0]); // 게임 횟수
        int Y = Integer.parseInt(input[1]); // 이긴 게임
        int Z = getPercent(X, Y);
        
        int result = -1;
        int left = 0;
        int right = 1_000_000_000;

        while(left<=right){
            int mid = (left+right)/2;
            
            if(getPercent(X+mid, Y+mid) != Z){
                result = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        bw.write(result+"\n");
        bw.flush();
        br.close();
        bw.close();
    }

    private static int getPercent(int X, int Y){
        return (int) (Y * 100L /X);
    }
}
