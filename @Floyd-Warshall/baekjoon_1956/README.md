[[gold4] #1956 운동](https://www.acmicpc.net/problem/1956)
---

- challenge : 도로 길이 합 가장 작은 사이클 찾기\
dist[i][j]=Math.min(dist[i][j], dist[i][k]+dist[k][j])

- challenge2: 사이클 탐색 (dp[i][j], dp[j][i] 무한이 아닌 길 존재) \
Math.min(result, dp[i][j]+dp[j][i]);

---

### 입력
```
3 4
1 2 1
3 2 1
1 3 5
2 3 2
```

---
### 출력
```
3
```