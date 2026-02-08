[[gold5] #19598 최소 회의실 개수](https://www.acmicpc.net/problem/19598)
---

- Prority Queue
- 배열 요소 우선순위 지정
    ```java
    PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
        @Override
        public int compare(int[] o1, int[] o2){
            if(o1[0]==o2[0]) return o1[1]-o2[1];
            return o1[0]=o2[0];
        }
    });
    ```
- challenge : 회의, 회의실 별도의 큐 관리

---

### 입력
```
3
0 40
15 30
5 10
```

---
### 출력
```
2
```