[[gold5] #2096 내려가기](https://www.acmicpc.net/problem/2096)
---

- Dynamic Programming
- Sliding Window
- 2차원 배열보다는 1차원 배열로 <현재 행 / 이전 행> 기록하면 공간 복잡도 줄이기 가능
    ```
    // 1차원 배열만 사용하여 이전 값을 덮어쓰는 방식 (복사본 필요)
    int[] maxDp = new int[3];
    int[] minDp = new int[3];

    for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        int n0 = Integer.parseInt(st.nextToken());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        if (i == 0) {
            maxDp[0] = minDp[0] = n0;
            maxDp[1] = minDp[1] = n1;
            maxDp[2] = minDp[2] = n2;
        } else {
            // 이전 상태 보존
            int prevMax0 = maxDp[0], prevMax1 = maxDp[1], prevMax2 = maxDp[2];
            maxDp[0] = Math.max(prevMax0, prevMax1) + n0;
            maxDp[1] = Math.max(prevMax0, Math.max(prevMax1, prevMax2)) + n1;
            maxDp[2] = Math.max(prevMax1, prevMax2) + n2;

            int prevMin0 = minDp[0], prevMin1 = minDp[1], prevMin2 = minDp[2];
            minDp[0] = Math.min(prevMin0, prevMin1) + n0;
            minDp[1] = Math.min(prevMin0, Math.min(prevMin1, prevMin2)) + n1;
            minDp[2] = Math.min(prevMin1, prevMin2) + n2;
        }
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