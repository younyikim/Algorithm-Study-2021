from collections import deque

T = int(input())

dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]

for _ in range(T):
    M, N, K = map(int, input().split())
    graph = []
    queue = deque([])

    for _ in range(N):
        graph.append([0 for _ in range(M)])

    for _ in range(K):
        X, Y = map(int, input().split())
        graph[Y][X] = 1

    cabbageCount = 0

    for i in range(0, N):
        for j in range(0, M):
            if graph[i][j] == 1:
                queue.append([i, j])
                graph[i][j] = -1
                while True:
                    y, x = queue.pop()
                    for d in range(4):
                        nX = dx[d] + x
                        nY = dy[d] + y
                        if 0 <= nX < M and 0 <= nY < N:
                            if graph[nY][nX] == 1:
                                graph[nY][nX] = -1
                                queue.append([nY, nX])

                    if not queue:
                        cabbageCount += 1
                        break

    print(cabbageCount)