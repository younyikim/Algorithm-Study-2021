# 간단한 다익스트라 알고리즘 코드 (O(V^2))
import sys
input = sys.stdin.readline
INF = int(1e9) # 임의로 무한값을 설정한다. (10억)

# n : 노드의 수 / m : 간선의 수
n, m = map(int, input().split())

# start : 시작노드
start = int(input())

# 노드정보
graph = [[] for _ in range(n+1)]

# 방문정보
visited = [False] * (n+1)

# 최단 거리 테이블 (무한으로 초기화)
distance = [INF] * (n+1)

# 모든 간선 정보 입력받기
for _ in range(m):
    a, b, c = map(int, input().split()) # a -> b (비용 c)
    graph[a].append((b, c))

# 가장 최단거리가 짧은 노드 반환 (방문하지 않은 노드 중)
def find_closest_node():
    min = INF # 최단거리의 최솟값
    index = 0 # 최단거리가 가장 짧은 node의 인덱스
    for i in range(1, n+1):
        if distance[i] < min and not visited[i]: # 만약 최단거리가 min보다 짧고 방문하지 않았으면
            min = distance[i] # min 갱신
            index = i # index 갱신
    return index

def dijkstra(start):
    # 시작 노드 초기화
    distance[start] = 0
    visited[start] = True
    
    for j in graph[start]:
        distance[j[0]] = j[1]
    
    # 나머지 노드 루프
    for i in range(n-1):
        v = find_closest_node() # 
        visited[v] = True

        for j in graph[v]:
            cost = distance[v] + j[1]
            if cost < distance[j[0]]:
                distance[j[0]] = cost

dijkstra(start)

for i in range(1, n+1):
    if distance[i] == INF:
        print("node ",i," can not visit")
    else:
        print("node ",i," : ", distance[i])

# 입력 예
# 6 11
# 1
# 1 2 3
# 1 3 5
# 1 4 1
# 2 3 3
# 2 4 2
# 3 2 3
# 3 6 5
# 4 3 3
# 4 5 1
# 5 3 1
# 5 6 2