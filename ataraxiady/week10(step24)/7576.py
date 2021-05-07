import sys
from collections import deque

def bfs(m, n, box):
    # 좌우
    dx = [0, 0, 1, -1]
    # 상하
    dy = [-1, 1, 0, 0]

    day = -1

    while ripe:
        day = day + 1
        for _ in range(len(ripe)):
            x, y = ripe.popleft()

            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]

                if(0 <= nx < n) and (0 <= ny < m) and (box[nx][ny] == 0):
                    box[nx][ny] = box[x][y] + 1
                    ripe.append([nx,ny])
    for b in box:
        # 안익은 토마토가 있을 시 -1 반환
        if 0 in b:
            return -1
    return day

m, n = map(int, sys.stdin.readline().split())
box = []
ripe = deque()

for i in range(n):
    row = list(map(int, sys.stdin.readline().split()))
    for j in range(m):
        if row[j] == 1: # 익은 토마토 발견
            ripe.append([i,j])
    box.append(row)


print(bfs(m, n, box))