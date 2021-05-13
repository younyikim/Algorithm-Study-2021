import sys
INF = int(1e9)

def bellman_ford(start):
    distance[start] = 0 # 시작 노드에 대해서 거리를 0으로 초기화
    for i in range(n): # 정점 수만큼 반복
        for j in range(m): # 매 반복 마다 모든 간선 확인
            node = graph[j][0] # 현재 노드 받아오기
            next_node = graph[j][1] # 다음 노드 받아오기
            cost = graph[j][2] # 가중치 받아오기
            # 현재 간선을 거려서 다른 노드로 이동하는 거리가 더 짧은 경우
            if distance[node] != INF and distance[next_node] > distance[node] + cost:
                distance[next_node] = distance[node] + cost
                # n번째 라운드에서도 값이 갱신된다면 음수 순환이 존재
                if i == n-1: # n-1번 이후 반복에도 값이 갱신되면 음수 순환 존재
                    return True
    return False


n, m = map(int, sys.stdin.readline().split())
distance = [INF] * (n + 1)
graph = []
for _ in range(m):
    a, b, c = map(int, sys.stdin.readline().split())
    graph.append((a, b, c))


answer = bellman_ford(1)

if answer:
    print('-1')
else:
    # 1번 노드를 제외한 다른 모든 노드로 가기 위한 최단 거리 출력
    for i in range(2, n+1):
        if distance[i] == INF: # 도달할 수 없는 경우 -1 출력
            print('-1')
        else: # 도달할 수 있는 겨우 거리를 출력
            print(distance[i])