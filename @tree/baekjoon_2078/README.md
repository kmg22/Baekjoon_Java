[[silver2] #2078 무한이진트리](https://www.acmicpc.net/problem/2078)
---

- (1,1) -> (A,B) 최단거리
- 이진 트리
- 수학

- try1 : 역추적(뺄셈) | `O(A+B)`
    ```
            while(!(A==1 && B==1)){
                if(A>=B){
                    A-=B;
                    L++;
                }else{
                    B-=A;
                    R++;
                }
            }
    ```
- try2 : 역추적(나눗셈 점프) - 같은 방향으로 연속으로 이어지는 구간 점프 | `O(log(min(A,B)))` 
    ```
            while(!(A==1 && B==1)){
                if(A>B){
                    tmp = (A-1)/B;
                    A-=tmp*B;
                    L+=tmp;
                }else{
                    tmp = (B-1)/A;
                    B-=tmp*A;
                    R+=tmp;
                }
            }
    ```

---
### 입력
```
3 4
```

---

### 출력
```
2 1
```