[#2295 세 수의 합](https://www.acmicpc.net/problem/2295)
---

- 이진탐색
- HashSet
- break point
    ```
    out:
    <반복문1>{
        <반복문2>{
            break out;
        }
    }
    // 중첩 반복문도 완전히 빠져나감
    ```

- 집합 = {x, y, z, k, ... }
    > x + y + z = k\
    > x + y = k - z

---

### 입력
```
5
2
3
5
10
18
```

---
### 출력
```
18
```