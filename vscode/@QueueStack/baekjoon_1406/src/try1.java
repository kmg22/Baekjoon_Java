// Buffer 입출력을 통해 시간초과 문제 해결
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class try1{
    public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        Editor editor = new Editor();
        for(int i=0; i<input.length(); i++){
            editor.add(input.charAt(i));
        }

        int M = Integer.parseInt(br.readLine());
        
        for(int i=0; i<M; i++){
            String command = br.readLine();
            if(command.charAt(0)=='P'){
                editor.command(command.charAt(0), command.charAt(2));
            }else{
                editor.command(command.charAt(0));
            }
        }
        bw.write(editor.all());
        bw.flush();

        br.close();
        bw.close();
    }
}

class Editor{
    private Node head;
    private Node tail;
    private Node cursor;
    private Node end;

    public Editor(){
        head = null;
        tail = null;
        end = new Node('E', null, null);
        cursor = end;
    }

    public void command(char c){
        switch(c){
            case 'L':
                left();
                break; 
            case 'D':
                right();
                break;
            case 'B':
                delete();
                break;
        }
    }
    public void command(char c, char word){
        // P command
        plus(word);        
    }

    public void add(char word){ // 마지막에 추가
        if(tail==null){ 
            Node tmp = new Node(word, null, end);
            head = tmp;
            tail = tmp;
            end.left = tail;
        }else{
            Node tmp = new Node(word, tail, end);
            tail.right = tmp;
            tail = tmp;
            end.left = tail;
        }
    }

    public void plus(char word){ // 왼쪽에 추가
        if(head==null){
            Node tmp = new Node(word, null, end);
            head = tmp;
            tail = tmp;
            end.left = tail;
        }else if(cursor==end){
            Node tmp = new Node(word, cursor.left, end);
            end.left.right = tmp;
            end.left = tmp;
            tail = tmp;
        }
        else{
            Node tmp = new Node(word, cursor.left, cursor);
            if(cursor==head){
                cursor.left = tmp;
                head = tmp;
            }else{
                cursor.left.right = tmp;
                cursor.left = tmp;
            }
        }
    }

    public void delete(){ // 삭제
        // 왼쪽에 문자 없을 경우(문자 없거나 cursor 맨 앞)
        if(head==null || cursor==head){
            return;
        }

        // 마지막 문자 남은 경우
        if(head==tail){
            head = null;
            tail = null;
            end.left = null;
            cursor = end;
            return;
        }

        // cursor End인 경우
        if(cursor==end){
            Node tmp = cursor.left;
            if(tmp.left==head){
                tail = head;
            }else{
                tail = tmp.left;
            }
            tmp.left.right = end;
            end.left = tmp.left;
            return;
        }
        
        // cursor 중간에 있을 경우
        Node tmp = cursor.left;// 삭제할 노드
        if(tmp==head){
            cursor.left = null;
            head = cursor;
        }else{
            tmp.left.right = cursor;
            cursor.left = tmp.left;
        }
    }

    public void left(){
        if(head==null || cursor==head){
            return;
        }
        cursor = cursor.left;
    }

    public void right(){
        if(cursor==end){
            return;
        }
        cursor = cursor.right;
    }

    public String all(){
        if(head == null) return "";
        StringBuilder sb = new StringBuilder();
        Node p = head;
        while(p != end){
            sb.append(p.word);
            p = p.right;
        }
        return sb.toString();
    }

}

class Node{
    char word;
    Node left;
    Node right;

    public Node(char word, Node left, Node right){
        this.word = word;
        this.left=left;
        this.right=right;
    }
}