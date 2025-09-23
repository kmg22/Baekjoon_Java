import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 컨테이너 수
        int M = Integer.parseInt(input[1]); // 우선순위 종류

        Stack<Integer>[] priority = new Stack[M+1];
        for(int i=1; i<=M; i++){
            priority[i] = new Stack<>();
        }

        int[] cntP = new int[M+1];
        Queue<int[]> rail = new LinkedList<>();
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            int p = Integer.parseInt(input[0]); // 우선순위
            int w = Integer.parseInt(input[1]); // 무게

            rail.add(new int[]{p, w});
            cntP[p]++;
        }

        int value=0, currentP=M;
        Stack<Integer> tmpQ = new Stack<>();
        while(!rail.isEmpty()){
            // 현재 처리 끝나면 다음 우선순위 container
            while(currentP>0 && cntP[currentP]==0){
                currentP--;
            }

            int[] item = rail.poll();
            int p = item[0];
            int w = item[1];

            if(p==currentP){ // 현재 처리해야 할 container
                while(!priority[p].isEmpty() && priority[p].peek() < w){ // 가벼운 것이 아래 있다면
                    int tmp =priority[p].pop();
                    tmpQ.add(tmp); // tmpQ로 빼기
                    value+=tmp;
                }
                priority[p].add(w);
                value+=w;
                while(!tmpQ.isEmpty()){
                    int tmp = tmpQ.pop();
                    priority[p].add(tmp);
                    value+=tmp;
                }
                cntP[p]--;
            
            }else{ // 레일에 추가
                rail.add(item);
                value+=w;
            }
        }
        bw.write(value+"");

        bw.flush();
        bw.close();
        br.close();
    }
}