import sys

sys.setrecursionlimit(10 ** 9)

N, R, Q = map(int, sys.stdin.readline().split())
Tree = [[] for _ in range(N + 1)]  # 트리 구성
node_count = [0] * (N + 1)  # 노드 개수
check = [True for _ in range(N + 1)]  # 방문여부

for _ in range(N - 1):
    U, V = map(int, sys.stdin.readline().split())
    Tree[U].append(V)
    Tree[V].append(U)


def count_node(r):
    node_count[r] = 1
    for node in Tree[r]:  # 연결된 노드 탐색
        if not node_count[node]:  # 방문가능하면
            count_node(node)
            node_count[r] += node_count[node]
    return


count_node(R)

for _ in range(Q):
    q = int(sys.stdin.readline())
    print(node_count[q])