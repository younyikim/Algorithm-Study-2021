
N = int(input())
M = int(input())

distance = [[int(1e9)] * (N + 1) for _ in range(N + 1)]

for i in range(1, N + 1):
    for j in range(1, N + 1):
        if i == j:
            distance[i][j] = 0

for _ in range(M):
    node_start, node_end, node_cost = map(int, input().split())
    if distance[node_start][node_end] > node_cost:
        distance[node_start][node_end] = node_cost

for k in range(1, N + 1):
    for i in range(1, N + 1):
        for j in range(1, N + 1):
            distance[i][j] = min(distance[i][j], distance[k][j] + distance[i][k])

for i in range(1, N + 1):
    for j in range(1, N + 1):
        if distance[i][j] >= int(1e9):
            print(0, end=' ')
        else:
            print(distance[i][j], end=' ')
    print()