[#9084 동전](https://www.acmicpc.net/problem/9084)
---

- Dynamic Programming
- knapsack problem
`dp[i][j] = dp[i-1][j] + dp[i][j-coins[i]]`\
-> 1~i번 코인 사용해서 j 값 만드는 최대 횟수
---

### 입력
```
3
2
1 2
1000
3
1 5 10
100
2
5 7
22
```

---
### 출력
```
501
121
1
```