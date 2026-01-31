/*
 * 1층은 무조건 무너지니까
 * 1층 누적 값 계산해서 한도 넘어가면 출력
 */

package vscode.baekjoon_27940.src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 농장 층 수
        int M = Integer.parseInt(input[1]); // 비 횟수
        int K = Integer.parseInt(input[2]); // 빗물 양 한도

        int sum = 0;
        boolean stop = false;

        // int[] t = new int[M];
        int[] r = new int[M];

        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");
            // t[i] = Integer.parseInt(input[0]);
            r[i] = Integer.parseInt(input[1]);
        }
        
        for(int i=0; i<M; i++){
            sum += r[i];
            if(sum > K){
                i++;
                bw.write(i + " " + 1);
                stop = true;
                break;
            }
        }

        if(!stop) bw.write("-1");

        bw.newLine();
        bw.flush();

        bw.close();
        br.close();
    }
}
