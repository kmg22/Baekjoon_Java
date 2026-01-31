[#9095 1,2,3 더하기](https://www.acmicpc.net/problem/9095)
---

- Dynamic Programming \
    `DP[i] = DP[i-1] + DP[i-2] + DP[i-3](i>=4)`
    |i| result|
    |:-:|:-:|
    |1|1|
    |2|2|
    |3|4|
    |4|7|
    |5|13|

---

### 입력
```
3
4
7
10
```

---
### 출력
```
7
44
274
```