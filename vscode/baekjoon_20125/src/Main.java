import java.io.*;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        char[][] a = new char[N+2][N+2];
        int heart_x=0, heart_y=0;
        int left_arm, right_arm, body, left_leg=0, right_leg=0, leg_start_x=0;

        for(int i=1; i<=N; i++){
            String input = br.readLine();
            for(int j=1; j<=N; j++){
                a[i][j] = input.charAt(j-1);
            }
        }

        // 심장 탐색(머리 바로 아래칸칸)
        for(int i=1; i<=N; i++){
            int tmpY = isStar(a[i]);
            if(tmpY>0){
                heart_x = i+1;
                heart_y = tmpY;
                bw.write(heart_x+" "+heart_y+"\n");
                bw.flush();
                break;
            }
        }

        // left arm
        for(int i=1; i<=N; i++){
            if(a[heart_x][i]=='*'){
                left_arm = heart_y - i;
                bw.write(left_arm+" ");
                break;
            }
        }

        // right arm
        for(int i=N; i>0; i--){
            if(a[heart_x][i]=='*'){
                right_arm = i - heart_y;
                bw.write(right_arm+" ");
                break;
            }
        }

        // body
        for(int i=heart_x+1; i<=N; i++){
            if(isStar(a[i])!=heart_y){
                leg_start_x = i;
                body = i - heart_x - 1;
                bw.write(body+" ");
                break;
            }
        }

        boolean left=false, right=false;
        for(int i=N; i>=leg_start_x; i--){
            if(!left && a[i][heart_y-1]=='*'){
                left_leg = i-leg_start_x+1;  
                left = true;
            }
            if(!right && a[i][heart_y+1]=='*'){
                right_leg = i-leg_start_x+1;
                right = true;
            }
        }
        bw.write(left_leg+" ");
        bw.write(right_leg+"");



        bw.newLine();
        bw.flush();

        br.close();
        bw.close();
    }

    public static int isStar(char a[]){
        for(int i=1; i<=N; i++){
            if(a[i] == '*'){
                return i;
            }
        }
        return 0;
    }
}
