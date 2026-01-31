[#15990 1,2,3 더하기 5](https://www.acmicpc.net/problem/15990)
---

- Dynamic Programming
    ```
    dp[i][1] = (dp[i-1][2]+dp[i-1][3])%mod;
    dp[i][2] = (dp[i-2][1]+dp[i-2][3])%mod;
    dp[i][3] = (dp[i-3][1]+dp[i-3][2])%mod;
    ```
    => result = dp[N][1]+dp[N][2]+dp[N][3]
- d[i][1] : i를 구성하기 위해 `1+n`의 조합으로 만들 수 있는 최소 개수 

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
3
9
27
```