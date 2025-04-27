import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");

            int[] rate = new int[N];
            for(int j=0; j<N; j++){
                rate[j] = Integer.parseInt(input[j]);
            }
            int win = test(N, rate);
            bw.write(win+"\n");
        }

        bw.newLine();
        bw.flush();

        br.close();
        bw.close();
    }

    public static int test(int N, int[] rate){
        int[][] point = new int[201][6]; // 각 팀별 팀원 점수
        int[] count = new int[201];
        boolean[] team = new boolean[201];
        int score = 0;

        for(int i=0; i<N; i++){
            count[rate[i]]++;
            if(count[rate[i]]>=6){
                team[rate[i]] = true;
            }
        }

        count = new int[201];
        for(int i=0; i<N; i++){
            int n = rate[i];
            if(team[n]){
                score++;
                point[n][count[n]] = score;
                count[n]++;
            }
        }

        count = new int[201];
        int winTeam = 0;
        int winScore = Integer.MAX_VALUE;
        for(int i=1; i<201; i++){
            if(team[i]){
                count[i] = point[i][0]+point[i][1]+point[i][2]+point[i][3];
                if(winScore>count[i]){
                    winTeam = i;
                    winScore = count[i];
                }else if(winScore==count[i]){
                    if(point[winTeam][4]>point[i][4]){
                        winTeam = i;
                        winScore = count[i];
                    }
                }
            }
        }
        return winTeam;
    }
}
