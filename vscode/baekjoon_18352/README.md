[#18352 특정 거리의 도시 찾기](https://www.acmicpc.net/problem/18352)
---

### 입력
```
4 4 2 1
1 2
1 3
2 3
2 4
```

---
### 출력
```
4
```

---
### 핵심코드
```
for(Node B : edges[A.num]){
    if(!visited[B.num] && distance[B.num]>(distance[A.num]+B.dist)){
        distance[B.num] = distance[A.num]+B.dist; // X~B 거리 갱신(X~A + A~B)
        q.add(new Node(B.num, distance[B.num]));
    }
}
```
start(X) | A | B

거리 : (X,B) > (X,A) + (A,B) 인 경우 갱신하고 q에 집어넣음