import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N, M;
    private static List<Integer>[] list;
    private static boolean flag;
    private static boolean[] isFriend;

    public static void main(String[] args) throws Exception {
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]); // 친구 수
        M = Integer.parseInt(input[1]); // 관계 수

        list = new ArrayList[N];

        for(int i=0; i<N; i++){
            list[i] = new ArrayList<>();
        }
        isFriend = new boolean[N];


        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");
            int F1 = Integer.parseInt(input[0]);
            int F2 = Integer.parseInt(input[1]);
            list[F1].add(F2);
            list[F2].add(F1);
        }

        for(int i=0; i<N; i++){
            isFriend[i]=true;
            dijkstra(i, 1);
            isFriend[i]=false;
            if(flag){ break; }
        }
        // 1-2-3-4-5
        //     0        // 무조건 0부터 시작하면 답이 안 나올 수도 있음

        int result=flag?1:0;
        bw.write(result+"\n");

        bw.flush();
        br.close();
        bw.close();
    }

    private static void dijkstra(int p, int depth){
        if(flag){return;}

        if(depth>=5){
            flag = true;
            return;
        }

        for(int f : list[p]){
            if(!isFriend[f]){
                isFriend[f] = true;
                dijkstra(f, depth+1);
                isFriend[f] = false;
            }
        }
    }
}
