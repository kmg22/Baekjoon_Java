[#2193 이친수](https://www.acmicpc.net/problem/2193)
---

- Dynamic Programming \
    `dp[i] = dp[i-1]+dp[i-2] (i>2)`
    |i|result|
    |:-:|:-:|
    |1|1|
    |2|1|
    |3|2|
    |4|3|
    |5|5|
- 주의 : 결과가 int형 범위 초과

---

### 입력
```
3
```

---
### 출력
```
2
```