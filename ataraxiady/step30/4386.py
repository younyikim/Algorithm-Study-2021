import sys
import math

# 크루스칼 알고리즘
# 1197번에서 가중치 계산만 추가

n = int(sys.stdin.readline())
location = []
arr=[]
for _ in range(n):
    x, y = map(float, sys.stdin.readline().split())
    location.append((x,y))

for i in range(n-1):
    for j in range(i,n):
        # 별 간 거리 계산 (가중치)
        dis = round(math.sqrt((location[i][0] - location[j][0]) ** 2 + (location[i][1] - location[j][1]) ** 2),2)
        if i == j:  # 자신으로 가는 거리는 계산하지않음
            continue
        # 양방향 저장
        arr.append((dis,i,j))
        arr.append((dis,j,i))


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

sum = 0
for c, a, b in arr:
    if find(a) != find(b):
        union(a, b)
        sum += c

print(sum)