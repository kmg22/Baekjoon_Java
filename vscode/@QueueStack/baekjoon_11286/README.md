[#11286 절대값의 힙](https://www.acmicpc.net/problem/11286)
---

- Priority Queue
- Comparator
    - return <  0 : o1이 높은 우선순위
    - return >  0 : o2가 높은 우선순위
    - return == 0 : 동일한 우선순위
    ```
    @Override
    public int compare(Integer o1, Integer o2){
        if(Math.abs(o1)==Math.abs(o2)){
            if(o1<o2){ return -1; }
            else { return 1;}
        }else{
            return Math.abs(o1)-Math.abs(o2);
        }
    }
    ```


---

### 입력
```
18
1
-1
0
0
0
1
1
-1
-1
2
-2
0
0
0
0
0
0
0
```

---
### 출력
```
-1
1
0
-1
-1
1
1
-2
2
0
```