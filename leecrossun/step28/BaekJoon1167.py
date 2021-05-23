# 트리의 지름
import sys
v = int(sys.stdin.readline())
node_graph = [[] for _ in range(v+1)]
for i in range(v):
    path = list(map(int, sys.stdin.readline().split()))
    path_len = len(path)
    for i in range(1, path_len//2):
        node_graph[path[0]].append([path[2*i-1], path[2*i]])
 
 
# DFS
result_first = [0 for _ in range(v+1)]
 
 
def DFS(start, matrix, result):
    for e, d in matrix[start]:
        if result[e] == 0:
            result[e] = result[start]+d
            DFS(e, matrix, result)
 
 
DFS(1, node_graph, result_first) # 시작
result_first[1] = 0
 
 
tmpmax = 0 # 최댓값
index = 0 # 최장경로 노드
 
for i in range(len(result_first)):
    if tmpmax < result_first[i]:
        tmpmax = result_first[i]
        index = i
 
# 최장경로 노드에서 다시 DFS
result_final = [0 for _ in range(v+1)]
DFS(index, node_graph, result_final)
result_final[index] = 0
print(max(result_final))