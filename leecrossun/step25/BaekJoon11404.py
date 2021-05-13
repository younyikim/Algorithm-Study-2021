# 플로이드
import sys
input = sys.stdin.readline
INF = int(1e9)

n = int(input()) # 노드의 개수
m = int(input()) # 간선의 개수

graph = [[INF] * (n + 1) for _ in range(n + 1)] # 최단거리 테이블

for s in range(1, n + 1):
    for e in range(1, n + 1):
        if s == e: # 그래프의 시작지점 == 도착지점
            graph[s][e] = 0 # 거리 0으로 초기화

# S0 : 그래프 초기화
for _ in range(m):
    s, e, dist = map(int, input().split())
    if graph[s][e] > dist:
        graph[s][e] = dist

# S1 ~ SN : 모든 노드를 돌며 각 노드를 거치는 모든 경로 검토
for node in range(1, n + 1): # 노드에 대한 루프
    for s in range(1, n + 1): # 2차원 그래프 루프
        for e in range(1, n + 1):
            graph[s][e] = min(graph[s][e], graph[s][node] + graph[node][e])

# 출력
for s in range(1, n + 1):
    for e in range(1, n + 1):
        if graph[s][e] == INF:
            print("0", end = ' ')
        else:
            print(graph[s][e], end = ' ')
    print()