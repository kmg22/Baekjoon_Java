[#1149 RGB 거리](https://www.acmicpc.net/problem/1149)
---

- Dynamic Programming \
    `dp[i][color] = Math.min(dp[i][color], dp[i-1][other_color]+RGB[i][color])`\
    i집 color 선택 시 (1~i집까지 고려) 가장 적은 비용 계산

---

### 입력
```
3
26 40 83
49 60 57
13 89 99
```

---
### 출력
```
96
```