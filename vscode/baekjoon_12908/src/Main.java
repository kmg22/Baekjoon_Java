import java.io.*;

public class Main {
    static int[][] tp = new int[3][4]; // x1 y1 x2 y2
    static int fast, extra;

    static int cal(int num, int xs, int ys, int xe, int ye){
        int pre = fast;
        int s1e2 = Math.abs(xs-tp[num][0])+Math.abs(ys-tp[num][1]) + Math.abs(xe-tp[num][2])+Math.abs(ye-tp[num][3]);
        int s2e1 = Math.abs(xs-tp[num][2])+Math.abs(ys-tp[num][3]) + Math.abs(xe-tp[num][0])+Math.abs(ye-tp[num][1]);
        
        fast = Math.min(fast, Math.min(s1e2, s2e1)+10) + extra;
        int k = Math.min(s1e2, s2e1)==s1e2?1:3;
        return pre<=fast?0:k; // fast 갱신 여부 및 좌표 순서
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int xs = Integer.parseInt(input[0]);
        int ys = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int xe = Integer.parseInt(input[0]);
        int ye = Integer.parseInt(input[1]);

        fast = Math.abs(xe-xs) + Math.abs(ye-ys);
        extra = 0;
        
        for(int i=0; i<3; i++){
            input = br.readLine().split(" ");
            tp[i][0] = Integer.parseInt(input[0]);
            tp[i][1] = Integer.parseInt(input[1]);

            tp[i][2] = Integer.parseInt(input[2]);
            tp[i][3] = Integer.parseInt(input[3]);
        }

        int last=-1; // 마지막 들린 tp
        int k; // tp의 순서(먼저 들린 좌표)
        boolean[] visit = new boolean[3]; // tp 방문여부
        for(int i=0; i<3; i++){
            k = cal(i, xs, ys, xe, ye);
            if(k>0){
                extra = Math.abs(xs-tp[i][k-1])+Math.abs(ys-tp[i][k])+10;
                last = i;
                visit[i] = true;
            }
        }
       

        if(last!=-1){ // tp 타는 게 더 빠른 경우
            k = cal(last, xs, ys, xe, ye);

            for(int i=0; i<2; i++){
                for(int j=0; j<3; j++){ // 또 다른 tp 타는 경우 계산
                    if(!visit[j]){
                        int tmp = (k==1)?3:1;
                        k = cal(i, tp[last][tmp-1], tp[last][tmp], xe, ye);
                        if(k>0){
                            extra += Math.abs(tp[last][tmp-1]-tp[j][k-1])+Math.abs(tp[last][tmp]-tp[j][k])+10;
                            last = j;
                            visit[j] = true;
                        }
                    }
                }
            }
        }
        

        bw.write(fast+"");
        bw.flush();

        br.close();
        bw.close();
    }
}
