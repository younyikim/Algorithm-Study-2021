import sys

V, E = map(int, sys.stdin.readline().split())

INF = sys.maxsize
arr = [[INF for _ in range(V)] for _ in range(V)]

for _ in range(E):
    i, j, c = map(int, sys.stdin.readline().split())
    arr[i-1][j-1] = c

for k in range(V):
    for i in range(V):  # from
        for j in range(V):  # to
            arr[i][j] = min(arr[i][j], arr[i][k] + arr[k][j])

result = INF
for i in range(V):
    result = min(result, arr[i][i])

if result == INF:
    print(-1)
else:
    print(result)