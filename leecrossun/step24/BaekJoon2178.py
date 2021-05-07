# 미로 탐색
import sys
from collections import deque


N, M = map(int, input().split()) # 도착지점
maze = [list(map(int, input())) for _ in range(N)] # 미로
cnt = [[0]*M for _ in range(N)]
cnt[0][0] = 1
visited = [[False]*M for _ in range(N)]
visited[0][0] = True

q = deque()
dir_r = [-1, 0, 1, 0]
dir_c = [0, 1, 0, -1]

def bfs(r, c):
    q.append([r,c]) # 방문 정점 저장
    maze[r][c] = 0 # 방문 체크
    while q:
        y, x = q.popleft() # 맨 앞 정점 pop
        if x == M and y == N:
            break

        for i in range(4):
            nX = x + dir_c[i]
            nY = y + dir_r[i]

            if 0 <= nX < M and 0 <= nY < N:
                if maze[nY][nX] == 1 and not visited[nY][nX]:
                    visited[nY][nX] = True
                    q.append([nY, nX])
                    cnt[nY][nX] += cnt[y][x] + 1

bfs(0, 0)
print(cnt[N-1][M-1])

