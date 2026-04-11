[[gold1] #2096 외판원 순회](https://www.acmicpc.net/problem/2096)
---

- TSP(Traveling Salesperson Problem)
- dfs
- dynamic programming
- bit masking
- dp[mask][idx] : 순회까지 남은 최소 비용
    - mask : 방문한 도시 기록
    - idx : 마지막 위치
- 한 번 방문한 도시는 다시 방문 x => `i->j` 최단 거리 계산 x
- 만약에 재방문 가능하다면 -> 플로이드 워셜 등의 방식으로 최단 거리 갱신 후 tsp

---
### 입력
```
4
0 10 15 20
5 0 9 10
6 13 0 12
8 8 9 0
```

---

### 출력
```
35
```