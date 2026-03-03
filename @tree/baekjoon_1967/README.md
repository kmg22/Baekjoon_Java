[[gold4] #1967 트리의 지름](https://www.acmicpc.net/problem/1967)
---

- 트리
- 가중치
- dfs
- dynamic programming
- dp[i][0] : Math.max(i~자식 노드의 left+right)
- dp[i][1] : Math.max(children)

---
### 입력
```
12
1 2 3
1 3 2
2 4 5
3 5 11
3 6 9
4 7 1
4 8 7
5 9 15
5 10 4
6 11 6
6 12 10
```

---

### 출력
```
45
```