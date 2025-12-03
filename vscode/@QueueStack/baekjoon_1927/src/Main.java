import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        MinHeap mHeap = new MinHeap();

        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            int x = Integer.parseInt(br.readLine());
            if(x>0){
                mHeap.insert(x);
            }else{
                int n = mHeap.delete();
                bw.write(n+"\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class MinHeap{
        List<Integer> heap;

        public MinHeap(){
            heap = new ArrayList<>();
            heap.add(0);
        }

        public void insert(int x){
            heap.add(x);
            int cur = heap.size()-1;
            int par = cur/2;
            while(cur>1 && (x<heap.get(par))){
                heap.set(cur, heap.get(par));
                heap.set(cur/2, x);

                cur = par;
                par = cur/2;
            }
        }

        public int delete(){
            if(heap.size()<2){
                return 0;
            }

            int out = heap.get(1); // root 값(가장 작은 값값)
            heap.set(1, heap.get(heap.size()-1)); // 마지막 노드를 root로 보내버림림
            heap.remove(heap.size()-1);

            int cur = 1, tmp=0;
            while(cur*2 < heap.size()){// 자식 있는 동안 반복
                int left = cur*2;
                int right = cur*2 +1;
                int small = 0;
                if(right<heap.size() && heap.get(left)>heap.get(right)){
                    small = right;
                }
                else{
                    small = left;
                }

                if(heap.get(cur)<heap.get(small)){
                    break;
                }

                tmp = heap.get(small);
                heap.set(small, heap.get(cur));
                heap.set(cur, tmp);
                cur = small;
            }
            return out;
        }
    }
}
