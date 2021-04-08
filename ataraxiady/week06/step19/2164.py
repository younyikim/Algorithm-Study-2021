import sys
from collections import deque

n = int(sys.stdin.readline())
q = deque([])

for i in range(n):
    q.append(i+1)

while len(q)>1:
    q.popleft()
    q.append(q.popleft())

print(q.pop())



# 시간초과
# while True:
#     if len(q) == 1:
#         print(*q)
#         False
#         break
#     else:
#         q.popleft()
#         temp = q[0]
#         for i in range(len(q)):
#             if i == (len(q)-1):
#                 q[i] = temp
#             else:
#                 q[i] = q[i+1]

