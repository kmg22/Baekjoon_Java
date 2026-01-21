[#17182 우주 탐사선](https://www.acmicpc.net/problem/17182)
---

- backtracking
- challenge : 방문한 행성 중복 방문 가능 -> 각 경로 최단 거리 갱신 후(floyd-warshall), result 탐색 시작

---

### 입력
```
4 1
0 83 38 7
15 0 30 83
67 99 0 44
14 46 81 0
```

---
### 출력
```
74
```