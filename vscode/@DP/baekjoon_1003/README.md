[#1003 피보나치 함수](https://www.acmicpc.net/problem/1003)
---

- Dynamic Programming \
    `fib[n][0] = fib[n-1][0] + fib[n-2][0]`
    `fib[n][1] = fib[n-1][1] + fib[n-2][1]`
    |i| result|
    |:-:|:-:|
    |0|{1, 0}|
    |1|{0, 1}|
    |2|{1, 1}|
    |3|{3, 2}|

---

### 입력
```
3
0
1
3
```

---
### 출력
```
1 0
0 1
1 2
```