[#912 연속합](https://www.acmicpc.net/problem/1912)
---

- Dynamic Programming \
    `dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);`
    `max = Math.max(max, dp[i]);`


---

### 입력
```
10
10 -4 3 1 5 6 -35 12 21 -1
```

---
### 출력
```
33
```