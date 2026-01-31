[#1699 제곱수의 합](https://www.acmicpc.net/problem/1699)
---

- Dynamic Programming \
    `dp[i] = min(dp[i], dp[i-j*j]+1)`
    |i| result||
    |:-:|:-:|:-:|
    |1|1|1²
    |2|2|1²+1²
    |3|3|1²+1²+1²
    |4|1|2²
    |5|2|2²+1²

---

### 입력
```
7
```

---
### 출력
```
4
```