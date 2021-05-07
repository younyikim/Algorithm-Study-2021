# 프린터 큐
import collections
t = int(input())

for _ in range(t):
    n, m = map(int, input().split())
    p = list(map(int, input().split()))
    deque = collections.deque(p)
    
    i = 0
    cnt = 0
    p.sort(reverse=True)
    sort_list = collections.deque(p)

    while 1:
        length = len(deque)
        if i >= length:
                i -= length
        if deque[i] == sort_list[0]:
            deque[i] = -1
            sort_list.popleft()
            cnt += 1
            if i == m:
                break
        i += 1
    
    print(cnt)