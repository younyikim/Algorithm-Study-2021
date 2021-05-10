import sys
import heapq
import collections
input = sys.stdin.readline

N, E = map(int, input().split())

graph = collections.defaultdict(list)
for _ in range(E):
    a, b, c = map(int, input().split())
    graph[a].append((c, b))
    graph[b].append((c, a))
v1, v2 = map(int, input().split())

def dijkstra(start: int):
    distance = [sys.maxsize for _ in range(N+1)]
    distance[start] = 0
    heap = []
    heapq.heappush(heap, (0, start))

    while heap:
        current_distance, current_node = heapq.heappop(heap)
        if distance[current_node] < current_distance:
            continue
        for d, n in graph[current_node]:
            next_distance = d + current_distance
            if next_distance < distance[n]:
                distance[n] = next_distance
                heapq.heappush(heap, (next_distance, n))
    return distance

start_d = dijkstra(1)
v1_d = dijkstra(v1)
v2_d = dijkstra(v2)
fast_d = min(start_d[v1] + v1_d[v2] + v2_d[N], start_d[v2] + v2_d[v1] + v1_d[N])

if fast_d < sys.maxsize:
    print(fast_d)
else:
    print(-1)