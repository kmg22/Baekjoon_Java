[#11051 이항 계수2](https://www.acmicpc.net/problem/11051)
---

- Dynamic Programming \
    `dp[n][k] = dp[n-1][k] + dp[n-1][k-1] (0<k<n)`
    `dp[n][k] = 1 (k=0 or k=n)`

---

### 입력
```
5 2
```

---
### 출력
```
10
```