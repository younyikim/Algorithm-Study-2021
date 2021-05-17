import sys
import heapq
INF = int(1e9)

v, e = map(int, sys.stdin.readline().split())
k = int(sys.stdin.readline())
# graph에 노드 정보 담기
graph = [[] for i in range(v + 1)]
for _ in range(e):
    u, vv, w = map(int,sys.stdin.readline().split())
    graph[u].append((vv, w))

def dijkstra(k):
    distance = [INF] * (v + 1)
    q = []
    # 시작 노드로 가기 위한 최단 경로를 0으로 설정하여 큐에 삽입
    heapq.heappush(q, (0, k))
    distance[k] = 0
    while q: # 큐가 비어있지 않다면
        # 가장 최단 거리가 짧은 노드에 대한 정보를 꺼내기
        dist, now = heapq.heappop(q)
        # 현재 노드가 이미 처리된 적이 있는 노드라면 무시한다.
        if distance[now] < dist:
            continue
        # 현재 노드와 연결된 다른 인접한 노드를 확인한다.
        for i in graph[now]:
            cost = dist + i[1]
            # 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧은 경우 갱신한다.
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))

    return distance


answer = dijkstra(k)

for i in range(1, v+1):
    if answer[i] == INF:
        print("INF")
    else:
        print(answer[i])