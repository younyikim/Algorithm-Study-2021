# 바이러스
N = int(input()) # 정점(컴퓨터)의 수
M = int(input()) # 간선(연결정보)의 수
graph = [[0] * (N+1) for _ in range(N+1)] # 그래프
for _ in range(M):
    d1, d2 = map(int, input().split())
    graph[d1][d2] = graph[d2][d1] = 1
visit = [0] * (N+1) #  방문체크
cnt = 0 # 바이러스에 걸린 컴퓨터의 수

def bfs(V):
    global cnt
    q = [V] # 방문 정점 저장
    visit[V] = 1 # 방문 체크
    while q:
        V = q.pop(0) # 맨 앞 정점 pop
        for i in range(1, N+1): # 그래프 정점 루프
            if (visit[i] == 0 and graph[V][i] == 1): # 방문 X, 현재 방문한 정점에 간선이 있으면
                q.append(i) # q 에 추가 (루프를 돌면서 현재 방문한 정점에 연결된 다른 정점이 차례대로 방문할 수 있도록!)
                visit[i] = 1 # 방문 체크
                cnt += 1 # 바이러스 집계

bfs(1)
print(cnt)

