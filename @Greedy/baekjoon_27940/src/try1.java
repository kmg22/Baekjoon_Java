/*
 * 시간 초과 문제 발생
 */

package vscode.baekjoon_27940.src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class try1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
        
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 농장 층 수
        int M = Integer.parseInt(input[1]); // 비 횟수
        int K = Integer.parseInt(input[2]); // 빗물 양 한도
        
        int[] t = new int[M];
        int[] r = new int[M];
        int[] cal = new int[N];

        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");
            t[i] = Integer.parseInt(input[0]);
            r[i] = Integer.parseInt(input[1]);
        }

        int num = -1; // K 초과하는 마지막 층 수
        int block = -1; // 무너지는 층 발생하는 빗물 회차
        for(int i=0; i<M; i++){
            for(int j=0; j<t[i]; j++){
                cal[j] += r[i];
                if(cal[j] > K){
                    num = j;
                    if(j == t[i]-1) break;
                }
            }
            if(num!=-1){
                block = i;
                break;
            }
        }

        if(num!=-1){
            int random = (int)(Math.random()*(num+1)) + 1;
            bw.write(block + " " + random);
        }
        else bw.write("-1");

        bw.newLine();
        bw.flush();

        bw.close();
        br.close();
    }
}
