[#1535 안녕](https://www.acmicpc.net/problem/1535)
---

- Dynamic Programming \
    `dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-L[i]]+J[i]) (L[i]<J)`\
    최대 소모 가능 체력 j 상황에서 >> 1~i번 사람 인사해서 가질 수 있는 최대 기쁨
- Knapsack Problem(배낭 문제)

---

### 입력
```
8
100 26 13 17 24 33 100 99
34 56 21 1 24 34 100 99
```

---
### 출력
```
135
```