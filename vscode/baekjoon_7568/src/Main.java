import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] people = new int[N][3];

        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            people[i][0] = Integer.parseInt(input[0]);
            people[i][1] = Integer.parseInt(input[1]);
            people[i][2] = 1;
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(i!=j && people[i][0]<people[j][0] && people[i][1]<people[j][1]){
                    people[i][2]++;
                }
            }
        }

        for(int i=0; i<N; i++){
            bw.write(people[i][2]+" ");
        }


        bw.newLine();
        bw. flush();

        br.close();
        bw.close();

    }
}
