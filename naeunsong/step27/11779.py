from heapq import heappop, heappush
INF = 1e9

def sol(start, end):
    dist = [INF for _ in range(N)]
    dist[start] = 0
    path = [-1 for _ in range(N)]
    q = []
    heappush(q, [0, start])
    while q:
        cost, point = heappop(q)
        for p, c in graph[point]:
            c += cost
            if c < dist[p]:
                dist[p] = c
                path[p] = point
                heappush(q, [c, p])
    return dist[end], path

N, M = int(input()), int(input())
graph = [[] for _ in range(N)]
for _ in range(M):
    S, E, C = map(int, input().split())
    graph[S-1].append([E-1, C])
start, end = map(int, input().split())


costResult, p = sol(start-1, end-1)

pathResult = [end-1]
temp = end-1
while p[temp] != -1:
    pathResult.append(p[temp])
    temp = p[temp]


    
print(costResult)
print(len(pathResult))
for i in pathResult[::-1]:
    print(i+1, end=' ')