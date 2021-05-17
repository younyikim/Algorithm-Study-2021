import sys

# 재귀 dfs

def dfs(v, g):
    visited[v] = 1
    for u in g[v]:
        if visited[u] != 1:
            dfs(u, g)

n = int(sys.stdin.readline()) #노드의 갯수
e = int(sys.stdin.readline()) #간선의 갯수
g = [[] for _ in range(n + 1)] #연결리스트
visited = [0] * (n + 1)

for _ in range(e):
    v, w = map(int, sys.stdin.readline().split())
    g[v].append(w)
    g[w].append(v)

dfs(1, g)
print(visited.count(1) - 1)


