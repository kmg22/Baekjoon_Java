[#11053 가장 긴 증가하는 부분 수열](https://www.acmicpc.net/problem/11053)
---

- Dynamic Programming \
    `dp[i] = Math.max(dp[i], dp[j]+1) (dp[i]>dp[j])`\
    dp[i] : {1~i번 요소} 수열 중 i번 요소를 사용하는 가장 긴 부분 수열 길이

---

### 입력
```
6
10 20 10 30 20 50
```

---
### 출력
```
4
```