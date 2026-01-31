import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, M;
    private static Queue<int[]> melt;
    private static int[][] cheeze;
    private static int[][] airCnt;
    private static boolean[][] visited;
    private static int[] dN = {-1, 1, 0, 0};
    private static int[] dM = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception{
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        
        cheeze = new int[N][M];
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                cheeze[i][j] = Integer.parseInt(input[j]);
            }
        }

        int result=0;
        while(true){
            BFS();
            
            boolean flag=true;
            while(!melt.isEmpty()){
                int[] tmp = melt.poll();
                int tmpN = tmp[0];
                int tmpM = tmp[1];
                cheeze[tmpN][tmpM]=0; 
                flag = false; // 녹는 치즈 존재 == 해당 라운드는 치즈가 존재했던 것
            }
            if(flag){ break; }

            result++;
        }

        bw.write(result+"\n");
        bw.flush();
        br.close();
        bw.close();
    }

    private static void BFS(){
        visited = new boolean[N][M];
        airCnt = new int[N][M];         // 인접한 외부 공기 개수
        melt = new LinkedList<>();      // 녹는 치즈 기록
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0});
        visited[0][0] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curN = cur[0];
            int curM = cur[1];

            for(int i=0; i<4; i++){
                int nN = curN + dN[i];
                int nM = curM + dM[i];

                if(nN>=0 && nN<N && nM>=0 && nM<M && !visited[nN][nM]){
                    // 주변 지역 : 공기
                    if(cheeze[nN][nM]==0){
                        q.add(new int[]{nN, nM});
                        visited[nN][nM] = true;
                    }
                    // 주변 지역 : 치즈
                    if(cheeze[nN][nM]==1){
                        if(++airCnt[nN][nM]>=2){
                            melt.add(new int[] {nN, nM});
                            visited[nN][nM] = true;
                        }
                    }
                }
            }
        }
    }
}