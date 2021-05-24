from heapq import heappop, heappush
INF = 1e9

def sol(start, end):
    dist = [INF for _ in range(N)]
    dist[start] = 0
    path = [-1 for _ in range(N)]
    q = []
    heappush(q, [0, start])
    while q:
        cost, point = heappop(q)
        for p, c in graph[point]:
            c += cost
            if c < dist[p]:
                dist[p] = c
                path[p] = point
                heappush(q, [c, p])
    return dist[end], path

N, M = int(input()), int(input())
graph = [[] for _ in range(N)]
for _ in range(M):
    S, E, C = map(int, input().split())
    graph[S-1].append([E-1, C])
start, end = map(int, input().split())
#함수 실행해서 최소비용과 경로배열 리턴
costResult, p = sol(start-1, end-1)
#경로배열에서 경로를 찾는 과정
pathResult = [end-1]
temp = end-1
while p[temp] != -1:
    pathResult.append(p[temp])
    temp = p[temp]
#결과 출력
print(costResult)
print(len(pathResult))
for i in pathResult[::-1]:
    print(i+1, end=' ')