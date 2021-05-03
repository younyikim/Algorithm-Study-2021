import sys

n, m, v = map(int, sys.stdin.readline().split())

edge = [[0]*(n+1) for i in range(n+1)]
for i in range(m):
    a, b = map(int,input().split())
    edge[a][b] = edge[b][a] = 1

visit_list=[0]*(n+1)

def dfs(v):
    visit_list[v] = 1 #방문한 점 1로 표시
    print(v, end=' ')
    for i in range(1,n+1):
        if(visit_list[i] == 0 and edge[v][i] == 1):
            dfs(i)

def bfs(v):
    queue = [v] #들려야 할 정점 저장
    visit_list[v] = 0 #방문한 점 0으로 표시
    while queue:
        v = queue.pop(0)
        print(v, end=' ')
        for i in range(1, n+1):
            if(visit_list[i] == 1 and edge[v][i] == 1):
                queue.append(i)
                visit_list[i] = 0

dfs(v)
print()
bfs(v)
