# 최소비용 구하기 2
import heapq, sys
input = sys.stdin.readline
INF = int(1e9)

n = int(input()) # 도시의 개수
m = int(input()) # 버스의 개수

graph = [[] for _ in range(n+1)]
for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((b,c)) # a -> b (비용 c)

start, end = map(int, input().split())

visited = [False] * (n+1)
distance = [INF] * (n+1)
trace = [0] * (n+1)

# print(graph)

def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0

    while q:
        dist, v = heapq.heappop(q) # 최단거리가 가장 짧은 노드 반환
        # print("v : ", v)
        if distance[v] < dist: # 현재 노드가 이미 처리되었으면
            # print("v : ", v)
            continue # 건너뛰기
        for i in graph[v]: # 현재 노드와 연결된 노드 확인
            cost = dist + i[1]
            if cost < distance[i[0]]: # 현재 노드를 거치는 게 더 빠를 경우
                distance[i[0]] = cost
                trace[i[0]] = v # 부모(?) 노드 갱신
                # print(trace, v)
                # print(distance)
                heapq.heappush(q, (cost, i[0]))

dijkstra(start)

cnt = 1
route = [end]
e = end
while 1:
    cnt += 1
    route.append(trace[e])
    e = trace[e]
    if e == start:
        break

print(distance[end])
print(cnt)
for i in range(cnt-1, -1, -1):
    print(route[i], end=' ')
