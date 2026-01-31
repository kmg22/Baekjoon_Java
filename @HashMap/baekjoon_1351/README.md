[#1351 무한 수열](https://www.acmicpc.net/problem/1351)
---

- 메모리 사용량 확인
```
Runtime.getRuntime().gc();
long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
bw.write(usedMemory + " bytes");
```
---

### 입력
```
10000000 3 3
```

---
### 출력
```
32768
```