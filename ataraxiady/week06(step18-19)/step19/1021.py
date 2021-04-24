import sys
from collections import deque

n, m = map(int, sys.stdin.readline().split())
nums = list(map(int, sys.stdin.readline().split()))
q = deque(range(1,n+1))
cnt = 0

for i in range(len(nums)):
    if nums[i] == q[0]:
        q.popleft()
        continue
    q_i = q.index(nums[i])

    # 뒤 -> 앞
    if q_i > len(q) // 2:
        q.rotate(len(q) - q_i)
        cnt = cnt + (len(q) - q_i)
    # 앞 -> 뒤
    elif q_i <= len(q) //2:
        q.rotate(-q_i)
        cnt = cnt + q_i
    q.popleft()


print(cnt)