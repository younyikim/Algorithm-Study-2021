# 타임머신
# 벨만-포드 알고리즘
n , m = map(int, input().split()) # n 노드의 수 / m 간선의 수

graph = []

for i in range(m):
    u, v, w = list(map(int, input().split()))
    graph.append([u, v, w])


def BellmanFord(src):
    # 1. 최단거리 테이블 초기화 ( 출발노드 0 / 나머지 INF )
    dist = [float("inf") for i in range(n+1)]
    dist[src] = 0

    negative_cycle = False # 음의 사이클 체크 flag

    # 2. 1~ n-1개의 노드를 사용한 최단거리 구하기 루프
    for i in range(n):
        for u, v, w in graph: # 입력받았던 그래프 돌기 /  u->v = w (비용)
            if dist[u] != float("inf") and dist[u]+w < dist[v]: # 1) dist[u]가 INF가 아니고, 2) dist[u] + w (지금 계산한 최단거리) 가 dist[v] (기존 최단거리) 보다 작으면
                dist[v] = dist[u]+w # 테이블 갱신
                if i == n-1: # 만약 i 가 n-1 까지 돌았다면 비정상적인 루프 -> 음의 사이클 존재
                    negative_cycle = True

    # 3. 음의 사이클 확인
    cycle = 0
    if negative_cycle == True:
        print("-1")
        cycle = 1

    if cycle == 0:
        for i in range(2, n+1):
            if dist[i] == float("inf"):
                print("-1")
            else:
                print(dist[i])


BellmanFord(1)