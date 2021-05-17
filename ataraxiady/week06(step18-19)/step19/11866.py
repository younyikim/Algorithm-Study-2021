import sys
from collections import deque

n,k = map(int,sys.stdin.readline().split())
q = deque([i for i in range(1,n+1)])
arr = []

# rotate를 사용하면 deque type으로 구현된 연결 리스트를 회전시킬 수 있다.
while q:
    #k-1개 만큼 왼쪽으로 회전
    q.rotate(-(k-1))
    arr.append(q.popleft())

print('<',end='')
for i in range(len(arr)):
    if i != len(arr)-1:
        print(arr[i], end = ', ')
    else:
        print(arr[i],end='>')

