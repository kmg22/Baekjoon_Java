[#1932 정수 삼각형](https://www.acmicpc.net/problem/1932)
---

- Dynamic Programming
`dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + tri[i][j]` \
(i, j)값까지 올 수 있는 합계 중 최댓값

---

### 입력
```
5
7
3 8
8 1 0
2 7 4 4
4 5 2 6 5
```

---
### 출력
```
30
```