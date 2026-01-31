[#12865 평범한 배낭](https://www.acmicpc.net/problem/12865)
---

- Dynamic Programming
- knapsack problem
`dp[i][j] = Math.max(dp[i-1][j], dp[i][j-weight]+value)`\
-> #16493 문제와 로직 거의 유사
---

### 입력
```
4 7
6 13
4 8
3 6
5 12
```

---
### 출력
```
14
```