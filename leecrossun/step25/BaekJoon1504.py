# 특정한 최단 경로
import heapq, sys
input = sys.stdin.readline
INF = int(1e9)
n, m = map(int, input().split())
graph = [[] for _ in range(n+1)]
visited = [False] * (n+1)

for _ in range(m):
    a, b, c = map(int, input().split()) # 양방향 그래프 입력
    graph[a].append((b, c))
    graph[b].append((a, c))

v1, v2 = map(int, input().split())
start = 1

def dijkstra(start):
    distance = [INF] * (n+1)
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0

    while q:
        dist, v = heapq.heappop(q) # 최단거리가 가장 짧은 노드 반환
        if distance[v] < dist: # 현재 노드가 이미 처리되었으면
            continue # 건너뛰기
        for i in graph[v]: # 현재 노드와 연결된 노드 확인
            cost = dist + i[1]
            if cost < distance[i[0]]: # 현재 노드를 거치는 게 더 빠를 경우
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))
    return distance

# start 다익스트라
d_start = dijkstra(start)
d_v1 = dijkstra(v1)
d_v2 = dijkstra(v2)

# start -> v1 -> v2 -> end
first_route = d_start[v1] + d_v1[v2] + d_v2[n]
# start -> v2 -> v1 -> end
second_route = d_start[v2] + d_v2[v1] + d_v1[n]
# 더 작은 것으로 선택
result = min(first_route, second_route)
print(result if result < INF else -1)
