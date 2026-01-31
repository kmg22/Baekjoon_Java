import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, M, result=Integer.MAX_VALUE;
    private static int[][] map;
    private static boolean[] isChicken;
    private static ArrayList<int[]> chicken = new ArrayList<>();
    private static ArrayList<int[]> house = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new int[N][N];

        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(input[j]);
                if(map[i][j]==1){ house.add(new int[] {i,j}); }
                else if(map[i][j]==2){ chicken.add(new int[]{i, j}); }
            }
        }
        isChicken = new boolean[chicken.size()];

        BackTracking(0, 0);

        bw.write(result+"\n");
        bw.flush();
        br.close();
        bw.close();
    }

    private static void BackTracking(int idx, int cnt){
        // 모든 위치 확인
        if(cnt==M){
            int dist=calc();
            result = Math.min(result, dist);
            return;
        }


        // 치킨집 탐색
        for(int i=idx; i<chicken.size(); i++){
            if(!isChicken[i]){
                isChicken[i]=true;
                BackTracking(i+1, cnt+1);
                isChicken[i]=false;
            }
        }
    }

    // 치킨거리 계산
    private static int calc(){
        int total=0;
        for(int i=0; i<house.size(); i++){
            int min = Integer.MAX_VALUE;
            int[] tmpH = house.get(i);
            
            // 각 집마다 치킨거리 계산
            for(int j=0; j<chicken.size(); j++){
                if(isChicken[j]){
                    int[] tmpC = chicken.get(j);
                    int dist = Math.abs(tmpC[0]-tmpH[0])+Math.abs(tmpC[1]-tmpH[1]);
                    min = Math.min(min, dist);
                }
            }
            total += min;
        }
        return total;
    }
}
