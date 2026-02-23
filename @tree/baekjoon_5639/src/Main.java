import java.io.*;
import java.util.*;

public class Main{
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static class Node{
        int num;
        Node left, right;

        Node(int num){
            this.num = num;
        }

        void insert(Node tmp){
            // left
            if(tmp.num < this.num){
                if(left!=null){ left.insert(tmp); }
                else{ left = tmp; }
                return;
            }
            // right
            if(right!=null){ right.insert(tmp); }
            else{ right = tmp; }
        }
    }

    private static void postorder(Node tmp) throws Exception{
        if(tmp.left!=null){ postorder(tmp.left); }
        if(tmp.right!=null){ postorder(tmp.right);}
        bw.write(tmp.num+"\n");
    }

    public static void main(String[] args) throws Exception {
        Node root = new Node(Integer.parseInt(br.readLine()));
        
        String input;
        while((input=br.readLine())!=null && !input.isEmpty()){
            root.insert(new Node(Integer.parseInt(input)));
        }

        postorder(root);

        bw.flush();
        br.close();
        bw.close();
    }
}
