[#11727 2×n 타일링 2](https://www.acmicpc.net/problem/11727)
---

- Dynamic Programming \
    `DP[i] = DP[i-1] + DP[i-2]*2 (i>=3)`
    |i| result|
    |:-:|:-:|
    |1|1|
    |2|3|
    |3|5|
    |4|11|
    |5|21|

---

### 입력
```
2
```

---
### 출력
```
3
```