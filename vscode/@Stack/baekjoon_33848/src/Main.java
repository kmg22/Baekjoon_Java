import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();

        Stack stack = new Stack(N);
        for(int i=0; i<N; i++){
            int q1 = sc.nextInt();
            if (q1==1 || q1==3){
                int q2 = sc.nextInt();
                stack.Controller(q1, q2);
            } else {
                stack.Controller(q1);
            }
        }
        sc.close();
    }
}
class Stack{
    private int[] arr;
    private int[][] query;
    private int top;
    private int qIndex;

    public Stack(int n){
        this.arr = new int[n];
        this.query = new int[n][2];
        this.top = -1;
        this.qIndex = -1;
    }

    public void Controller(int q1, int q2){
        switch(q1){
            case 1:
                push(q2);
                break;
            case 3:
                cancel(q2);
                break;
        }
    }

    public void Controller(int q1){
        switch(q1){
            case 2:
                pop();
                break;
            case 4:
                size();
                break;
            case 5:
                top();
                break;
        }
    }

    private void push(int x){
        arr[++top] = x;
        query[++qIndex][0] = 1; // push
        query[qIndex][1] = x;
        // System.out.println(qIndex + " * ");
    }

    private void pop(){
        if(top==-1){
            return;
        } else {
            query[++qIndex][0] = 2; // pop
            query[qIndex][1] = arr[top];
            top--;
        }
        // System.out.println(qIndex + " * ");

    }

    private void cancel(int x){
        for(int i=0; i<x; i++){
            if(qIndex<0) break;

            switch(query[qIndex][0]){
                case 1:
                    pop();
                    qIndex-=2;
                    break;
                case 2:
                    push(query[qIndex][1]);
                    qIndex-=2;
                    break;
            }
        }
    }

    private void size(){
        System.out.println(top+1);
    }

    private void top(){
        if(top==-1){
            System.out.println(-1);
        } else {
            System.out.println(arr[top]);
        }
    }


}
