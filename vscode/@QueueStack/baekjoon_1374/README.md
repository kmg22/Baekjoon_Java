[#1374 강의실](https://www.acmicpc.net/problem/1374)
---

- priority queue
  - pq : 가장 빠르게 이용 가능한 강의실 시간
  - lecture : 강의 정보(시작시간, 종료시간) => 시작시간 빠른 것부터 out
    ```
    PriorityQueue<long[]> lecture = new PriorityQueue<>(
            Comparator.comparingLong((long[] a)->a[0])
                    .thenComparingLong(a->a[1]) // 시작 시간 같으면 종료시간 비교
        );
    ```
---

### 입력
```
8
6 15 21
7 20 25
1 3 8
3 2 14
8 6 27
2 7 13
4 12 18
5 6 20
```

---
### 출력
```
5
```