import sys

n = int(sys.stdin.readline())
location = []
arr = []
for i in range(n):
    x, y, z = map(int, sys.stdin.readline().split())
    location.append((x, y, z, i))

for j in range(3):
    location.sort(key=lambda x:x[j])
    before_location = location[0][3]
    for i in range(1, n):  # 각 좌표별로 간선추가
        cur_location = location[i][3]
        arr.append([abs(location[i][j] - location[i - 1][j]), before_location, cur_location])
        before_location = cur_location

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


count = 0
sum = 0
for c, a, b in arr:
    if find(a) != find(b):
        union(a, b)
        sum += c
    if count == n-1:
        break

print(sum)
