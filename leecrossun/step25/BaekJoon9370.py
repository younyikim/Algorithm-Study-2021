# 미확인 도착지
import heapq
T = int(input())
INF = int(1e9)

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

for _ in range(T):
    # n : 정점수 / m : 간선수 / t : 목적지 후보 수
    n, m, t = map(int, input().split())
    # s : 출발지 / g->h 반드시 지남
    s, g, h = map(int, input().split())

    visited = [False] * (n+1)

    graph = [[] for _ in range(n+1)]
    for _ in range(m):
        a, b, d = map(int, input().split())
        graph[a].append((b, d))
        graph[b].append((a, d))
    
    end = [int(input()) for _ in range(t)]

    answer = []
    
    start_d = dijkstra(s)
    g_d = dijkstra(g)
    h_d = dijkstra(h)

    
    minimum = INF

    for e in end:
        # s -> g -> h -> end
        route_1 = start_d[g] + g_d[h] + h_d[e]
        # s -> h -> g -> end
        route_2 = start_d[h] + h_d[g] + g_d[e]

        result = min(route_1, route_2)

        route_3 = start_d[e]

        if result == route_3:
            answer.append(e)
            
    answer.sort()
    for a in answer:
        print(a, end=' ')
    print()









