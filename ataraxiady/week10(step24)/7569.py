import sys
from collections import deque

def bfs(m, n, h, box):
    # 좌우
    dx = [0, 0, 1, -1, 0, 0]
    # 상하
    dy = [-1, 1, 0, 0, 0, 0]
    # 위아래
    dz = [0, 0, 0, 0, -1, 1]

    day = -1

    while ripe:
        day = day + 1
        for _ in range(len(ripe)):
            z, x, y = ripe.popleft()

            for i in range(6):
                nx = x + dx[i]
                ny = y + dy[i]
                nz = z + dz[i]

                if(0 <= nx < n) and (0 <= ny < m) and (0 <= nz < h) and (box[nz][nx][ny] == 0):
                    box[nz][nx][ny] = box[z][x][y] + 1
                    ripe.append([nz, nx, ny])
    for b in box:
        # 안익은 토마토가 있을 시 -1 반환
        if 0 in b:
            return -1
    return day

m, n, h = map(int, sys.stdin.readline().split())
box = []
ripe = deque()

for i in range(h):
    for j in range(n):
        row = list(map(int, sys.stdin.readline().split()))
        for k in range(m):
            if row[k] == 1: # 익은 토마토 발견
                ripe.append([i, j, k])
        box.append(row)


print(bfs(m, n, h, box))