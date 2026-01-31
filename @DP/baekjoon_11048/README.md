[#11048 이동하기](https://www.acmicpc.net/problem/11048)
---

- Dynamic Programming \
    `dp[i][j] = Math.max(dp[i][j], maze[i][j]+dp[tmpN][tmpM]);`\
    (1,1)에서 (i,j)까지 최대값 => (i-1,j), (i,j-1), (i-1,j-1) 비교 

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