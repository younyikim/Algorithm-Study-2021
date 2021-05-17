# DFS 와 BFS
N, M, V = map(int, input().split()) # N 정점의 개수, M 간선의 개수, V 탐색 시작 정점
graph = [[0] * (N+1) for _ in range(N+1)] # 그래프
for i in range(M):
    d1, d2 = map(int, input().split())
    graph[d1][d2] = graph[d2][d1] = 1 # 양방향 간선 표시
visit = [0] * (N+1) # 방문한 정점

def dfs(V):
    visit[V] = 1 # 방문 체크
    print(V, end=' ')
    for i in range(1,N+1): # 그래프 정점 루프
        if (visit[i] == 0 and graph[V][i] == 1): # 방문 X, 현재 방문한 정점에 간선이 있으면
            dfs(i) # 해당 정점 방문


def bfs(V):
    q = [V] # 방문 정점 저장
    visit[V] = 0 # 방문 체크
    while q:
        V = q.pop(0) # 맨 앞 정점 pop
        print(V, end=' ')
        for i in range(1, N+1): # 그래프 정점 루프
            if (visit[i] == 1 and graph[V][i] == 1): # 방문 X, 현재 방문한 정점에 간선이 있으면
                q.append(i) # q 에 추가 (루프를 돌면서 현재 방문한 정점에 연결된 다른 정점이 차례대로 방문할 수 있도록!)
                visit[i] = 0 # 방문 체크

dfs(V)
print("")
bfs(V)
