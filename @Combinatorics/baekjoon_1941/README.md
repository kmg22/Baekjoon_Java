[#1941 소문난 칠공주](https://www.acmicpc.net/problem/1941)
---

- 조합론
- backtracking
- BFS

- challenge1 : 2차원 배열을 1차원 인덱스 매칭하기 \
            (ex. 2행 3열 학생 == 2*5+3 == 13번 학생 )

- 구현 로직
    1. 조합 구성 <BackTracking>
    2. Y 4명 이상 시 -> 조합 탐색 중지
    3. combi 7명 채울 시 -> 가로, 세로 인접한지 검사 <BFS>
    4. 반복

---

### 입력
```
YYYYY
SYSYS
YYYYY
YSYYS
YYYYY
```

---
### 출력
```
2
```