[[gold4] #1504 특정한 최단 경로](https://www.acmicpc.net/problem/1504)
---

- dijkstra
- 최단 거리 구하기
- dijkstra(i) // i->각 지점까지의 최단 거리 dist 배열에 저장
- challenge : 구간별 최단 경로 합 구한 결과가 MAX 초과할 수 있음 \
-> `MAX=Integer.MAX_VALUE/3;` 이런식으로 조정해서 bufferoverflow 발생하지 않도록 주의

---
### 입력
```
4 6
1 2 3
2 3 3
3 4 1
1 3 5
2 4 5
1 4 4
2 3
```

---

### 출력
```
7
```