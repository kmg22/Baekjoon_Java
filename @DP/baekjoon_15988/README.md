[#15988 1,2,3 더하기 3](https://www.acmicpc.net/problem/15988)
---

- Dynamic Programming \
    `dp[i] = (dp[i-1]+dp[i-2]+dp[i-3]) % 1_000_000_009`
- (dp[i-1]+dp[i-2]+dp[i-3]) 값이 int 범위를 벗어날 수 있기에 long형 지정 필요
- #9095 문제와 유사

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