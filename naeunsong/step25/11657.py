import sys

N, M = map(int, sys.stdin.readline().split())
bus_way = [[] for _ in range(N+1)]

for _ in range(M):
    A, B, C = map(int, sys.stdin.readline().split())
    bus_way[A].append([B,C])

def bellman_ford(graph,start):
    distance = [float('INF') for _ in range(N+1)]
    distance[start] = 0
    for _ in range(N-1):
        for index in range(1,N+1):
            for nei in graph[index]:
                if distance[nei[0]] > distance[index] + nei[1]:
                    distance[nei[0]] = distance[index] + nei[1]

    for index in range(1, N):
        for nei in graph[index]:
            if distance[nei[0]] > distance[index] + nei[1]:
                return -1
    return distance

distance = bellman_ford(bus_way,1)

if distance == -1: print(-1)
else:
    for value in distance[2:]:
        if value == float("INF"): print(-1)
        else: print(value)

