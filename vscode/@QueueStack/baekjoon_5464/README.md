[#5464 주차장](https://www.acmicpc.net/problem/5464)
---
- 우선순위 큐
    - 값 낮은 것부터 out \
    `PriorityQueue<Integer> pq = new PriorityQueue<>();`
    - 값 높은 것부터 out \
    `PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());`



---

### 입력
```
3 4
2
3
5
200
100
300
800
3
2
-3
1
4
-4
-2
-1
```

---
### 출력
```
5300
```