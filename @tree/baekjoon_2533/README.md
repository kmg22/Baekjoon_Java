[[gold3] #2533 사회망 서비스(SNS)](https://www.acmicpc.net/problem/2533)
---

- 트리
- DFS
- Dynamic Programming \
    - dp[i][0] = dp[next][1]
    - dp[i][1] += Math.min(dp[next][0], dp[next][1])
    
    => <i~서브트리>에서 필요한 최소 얼리어댑터 개수

---
### 입력
```
8
1 2
1 3
1 4
2 5
2 6
4 7
4 8
```

---

### 출력
```
3
```