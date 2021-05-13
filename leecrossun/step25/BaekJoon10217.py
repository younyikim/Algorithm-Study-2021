# KCM Travel - pypy3
import sys
import heapq
input = sys.stdin.readline

T = int(input())
INF = int(1e9)

def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start, 0))
    distance[start][0] = 0

    for cash in range(total_money+1):
        for des in range(1, n+1):
            if distance[des][cash] == INF:
                continue
            time = distance[des][cash]
            for b, c, d in graph[des]:
                if c + cash > total_money:
                    continue
                distance[b][cash + c] = min(distance[b][cash + c] , time + d)


for _ in range(T):
    n, total_money, m = map(int, input().split()) # 노드의 수 (공항) / 지원비용 / 간선의 수 (티켓정보)
    start = 1
    graph = [[] for _ in range(n+1)]
    distance = [[INF for _ in range(total_money+1)] for _ in range(n+1)]

    # 모든 간선 정보 입력받기
    for _ in range(m):
        a, b, c, d= map(int, input().split()) # a -> b (비용 c 소요시간 d)
        graph[a].append((b, c, d))
    
    dijkstra(start)

    result = min(distance[n])

    if result == INF:
        print("Poor KCM")
    else:
        print(result)
    
