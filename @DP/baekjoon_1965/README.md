[#1965 상자넣기](https://www.acmicpc.net/problem/1965)
---

- Dynamic Programming \
    `dp[i] = Math.max(dp[i], dp[j]+1)`\
    (1~(i-1))상자를 i상자에 넣을 때 최대값 

---

### 입력
```
3 4
1 2 3 4
0 0 0 5
9 8 7 6
```

---
### 출력
```
31
```