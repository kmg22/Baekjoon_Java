import java.io.*;

public class Main {
    static int[] preorder;
    static int[] inorder;
    static StringBuilder sb;

    static void postorder(int root, int start, int end){
        for(int i=start; i<end; i++){
            if(preorder[root] == inorder[i]){
                postorder(root+1, start, i); // left
                postorder(root+(i-start+1), i+1, end); // right
                sb.append(preorder[root]).append(" "); // root
                return;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            preorder = new int[N+1];
            inorder = new int[N+1];

            String[] input = br.readLine().split(" ");
            for(int j=0; j<N; j++)
                preorder[j] = Integer.parseInt(input[j]);
            
            input = br.readLine().split(" ");
            for(int j=0; j<N; j++)
                inorder[j] = Integer.parseInt(input[j]);
            
            postorder(0, 0, N);
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }
}
