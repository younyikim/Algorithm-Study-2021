# 최소 스패닝 트리
import sys, heapq
input = sys.stdin.readline

def prim(v):
    q = []
    visited = [False] * (V+1)
    visited[v] = True
    d, cnt = 0, 1
    for a in graph[v]:
        heapq.heappush(q, a)
    
    while q:
        c, v = heapq.heappop(q)
        if not visited[v]:
            visited[v] = True
            cnt += 1
            d += c
            for a in graph[v]:
                heapq.heappush(q, a)
            
        if cnt == V:
            return d
    return 0

V, E = map(int, input().split())
graph = [[] for _ in range(V+1)]

for _ in range(E):
    A, B, C = map(int, input().split())
    graph[A].append((C, B))
    graph[B].append((C, A))

print(prim(1))

