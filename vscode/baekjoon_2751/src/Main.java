/*
 * Arrays.sort() 정렬 알고리즘 활용
 * Dual-Pivot Quicksort 알고리즘  O(n log n) 시간 복잡도
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));


        int N = 1000000;
        N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        for(int i=0; i<N; i++)
            nums[i] = Integer.parseInt(br.readLine());
        
        Arrays.sort(nums);
        
        StringBuilder sb = new StringBuilder();
        for(int num : nums)
            sb.append(num).append('\n');

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
