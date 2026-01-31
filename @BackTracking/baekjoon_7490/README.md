[#7490 0 만들기](https://www.acmicpc.net/problem/7490)
---

- backtracking
- 문자열 + iterator
    ```java
    Iterator<Integer> it = Arrays.stream(str.split("[+,-]"))
                            .map(Integer::parseInt)
                            .collect(toList()).iterator();
    ```
    - `split("[+,-]")`
        - `+` 또는 `-` 기준으로 자르기
    - `Arrays.stream()`
        - `String[]` 배열을 Stream 객체로 변환\
            -> 각 요소 순회 가능하도록
    - `.map(Integer::parseInt)`
        - 각 요소를 int형 변환
    - `.collect(toList())`
        - 요소들을 `List`에 담기
    - `.iterator()`
        - 리스트에 대한 iterator 객체 생성

---

### 입력
```
2
3
7
```

---
### 출력
```
1+2-3

1+2-3+4-5-6+7
1+2-3-4+5+6-7
1-2 3+4+5+6+7
1-2 3-4 5+6 7
1-2+3+4-5+6-7
1-2-3-4-5+6+7
```