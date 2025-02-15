/*
 * 감독관의 수가 많아질 수 있으므로
 * int 타입으로는 해결 안 됨 주의
 */
package vscode.baekjoon_13458.src;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 시험장 수

        int[] A = new int[N]; // 각 시험장별 학생생
        String[] input = br.readLine().split(" ");
        for(int i=0; i<N; i++)
            A[i] = Integer.parseInt(input[i]);
        
        input = br.readLine().split(" ");
        int B = Integer.parseInt(input[0]); // 총감독관 감시 가능 수
        int C = Integer.parseInt(input[1]); // 부감독관 감시 가능 수

        long cnt=0;
        for(int i=0; i<N; i++){
            cnt++; // (총)감독관 수 증가
            A[i] -= B;
            if(A[i]>0){
                cnt += (A[i]/C);
                cnt += ((A[i]%C)>0) ? 1 : 0;
            }
        }

        bw.write(String.valueOf(cnt));
        bw.newLine();
        bw.flush();

        br.close();
        bw.close();
    }
}
