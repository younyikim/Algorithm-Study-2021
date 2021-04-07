# 요세푸스 문제 0
import collections
n, k = map(int, input().split())
deque = collections.deque([])

k -= 1

for i in range(1,n+1):
    deque.append(i)

print("<", end='')

while len(deque) > 1:
    deque.rotate(-1 * k)
    print(deque.popleft(), end='')
    print(",", end=' ')

print(deque[0], end='')
print(">")

