[#16493 최대 페이지 수](https://www.acmicpc.net/problem/16493)
---

- Dynamic Programming
- knapsack problem
`dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-day] + page)`

---

### 입력
```
7 7
3 10
5 20
1 10
1 20
2 15
4 40
2 200
```

---
### 출력
```
260
```