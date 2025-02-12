/*
 * buffer 라이브러리 활용 입출력 최적화
 * 여전히 시간초과 오류 발생
 */

 import java.io.BufferedReader;
 import java.io.BufferedWriter;
 import java.io.InputStreamReader;
 import java.io.OutputStreamWriter;
 
 public class try2 {
     public static void main(String[] args) throws Exception {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
 
 
         int N = 1000000;
         N = Integer.parseInt(br.readLine());
         int[] nums = new int[N];
 
         for(int i=0; i<N; i++)
             nums[i] = Integer.parseInt(br.readLine());
 
         for(int i=0; i<N-1; i++)
             for(int j=0; j<N-i-1; j++)
                 if(nums[j] > nums[j+1]){
                     int tmp = nums[j];
                     nums[j] = nums[j+1];
                     nums[j+1] = tmp;
                 }
         
         StringBuilder sb = new StringBuilder();
         for(int num : nums)
             sb.append(num).append('\n');
 
         bw.write(sb.toString());
         bw.flush();
         bw.close();
         br.close();
     }
 }

