import sys
import math

n, m = map(int, sys.stdin.readline().split())
location = []
arr = []
for _ in range(n):
    x, y = map(int, sys.stdin.readline().split())
    location.append((x,y))

for i in range(n-1):
    for j in range(i,n):
        # 거리 계산 (이전 문제와 다르게 전체 값을 다 구해줘야함)
        dis = math.sqrt((location[i][0] - location[j][0]) ** 2 + (location[i][1] - location[j][1]) ** 2)
        if i == j:  # 자신으로 가는 거리는 계산하지않음
            continue
        arr.append((dis,i,j))


arr.sort(key=lambda x: x[0])
parent = list(range(n + 1))

#유니온 파인드 연산
def union(a, b):
    a = find(a)
    b = find(b)

    if b < a:
        parent[a] = b
    else:
        parent[b] = a
def find(a):
    if a == parent[a]:
        return a
    parent[a] = find(parent[a])  # 경로 압축
    return parent[a]

# 연결 간선 개수
count = 0
for _ in range(m):
    a, b = map(int, sys.stdin.readline().split())
    # 연결할 수 있다면
    if find(a-1) != find(b-1):
        union(a-1,b-1)
        count = count + 1

sum = 0
for c, a, b in arr:
    if find(a) != find(b):
        union(a, b)
        sum += c
        count = count + 1
    if count == n-1:
        break


print("%0.2f" %sum)



