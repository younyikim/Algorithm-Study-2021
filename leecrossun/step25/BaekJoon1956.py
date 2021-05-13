# 운동 - pypy3 로만 시간초과x
import sys
input = sys.stdin.readline
n, m = map(int, input().split())
INF = int(1e9)

graph = [[INF] * (n + 1) for _ in range(n + 1)] # 최단거리 테이블

# S0 : 그래프 초기화
for _ in range(m):
    s, e, dist = map(int, input().split())
    graph[s][e] = dist

# S1 ~ SN : 모든 노드를 돌며 각 노드를 거치는 모든 경로 검토
for node in range(1, n + 1): # 노드에 대한 루프
    for s in range(1, n + 1): # 2차원 그래프 루프
        for e in range(1, n + 1):
            graph[s][e] = min(graph[s][e], graph[s][node] + graph[node][e])

# 출력
result = INF
for s in range(1, n + 1):
    for e in range(1, n + 1):
        if graph[s][e] != INF and s == e and result > graph[s][e]:
            result = graph[s][e]

if result == INF:
    print(-1)
else:
    print(result)