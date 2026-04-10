[[gold5] #1717 집합의 표현](https://www.acmicpc.net/problem/1717)
---

- Union-Find(서로소 집합)
- 경로 압축
```java
private static int find(int e){
    if(parent[e] == e){ return e; }
    return parent[e] = find(parent[e]); // 경로 압축!
}
```

---
### 입력
```
5
-1 0 0 1 1
2
```

---

### 출력
```
2
```