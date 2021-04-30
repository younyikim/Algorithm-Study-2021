# 트리의 부모 찾기
import sys, collections
input = sys.stdin.readline
N = int(input())
t = [[] for _ in range(N+1)]
parants = [0] * (N+1)
for _ in range(N-1):
    a, b = list(map(int, input().split()))
    t[a].append(b)
    t[b].append(a)

q = collections.deque()
q.append(1)
a = {}
visit = [0] * (N+1)

while q:
    p = q.popleft()
    for i in t[p]:
        if visit[i] == 0:
            a[i] = p
            q.append(i)
            visit[i] = 1

for i in range(2, N+1):
    print(a[i])