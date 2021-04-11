import sys
from collections import deque

nn = int(sys.stdin.readline())

for _ in range(nn):
    n, m = map(int, sys.stdin.readline().split())
    arr = deque(map(int, sys.stdin.readline().split()))
    cnt = 0
    while arr:
        top = max(arr)
        m = m -1
        pop = arr.popleft()
        if top != pop:
            arr.append(pop)
            if m < 0:
                m = len(arr)-1
        else:
            cnt = cnt + 1
            if m == -1:
                print(cnt)
                break