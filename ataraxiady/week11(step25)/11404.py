import sys
INF = int(1e9)

n = int(sys.stdin.readline())
m = int(sys.stdin.readline())

graph = [[INF] * (n + 1) for _ in range(n + 1)]
for i in range(1, n + 1):
    graph[i][i] = 0

for _ in range(m):
    a, b, c = map(int, sys.stdin.readline().split())
    if graph[a][b] > c:
        graph[a][b] = c


def floyd():
    for cross in range(1, n + 1):
        for s in range(1, n + 1):
            if cross == s:
                continue
            for e in range(1, n + 1):
                if cross == e or s == e:
                    continue

                if graph[s][e] > graph[s][cross] + graph[cross][e]:
                    graph[s][e] = graph[s][cross] + graph[cross][e]


floyd()
for a in range(1, n + 1):
    for b in range(1, n + 1):
        if graph[a][b] == INF:
            print(0, end=" ")
        else:
            print(graph[a][b], end=" ")
    print()