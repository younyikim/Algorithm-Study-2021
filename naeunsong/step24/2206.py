import sys
from collections import deque

dx = [-1,0,1,0]
dy = [0,1,0,-1]

n, m = map(int, input().split())
q = deque()

arr = []
for _ in range(n):
    arr.append(list(map(int, sys.stdin.readline().strip())))

road_cnt = [[[0 for _ in range(m)] for _ in range(n)] for _ in range(2)]



def bfs(x, y, z):

    q.append((x, y, z))

    # 벽 안 뚫고
    while len(q) != 0:

        x, y, z = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx >= 0 and nx < n and ny >= 0 and ny < m and road_cnt[z][nx][ny] == 0:


                if arr[nx][ny] == 1 and z == 0:
                    road_cnt[1][nx][ny] = road_cnt[0][x][y] + 1
                    q.append((nx,ny,z))
                    z = 1

                elif arr[nx][ny] == 0:
                    road_cnt[z][nx][ny] = road_cnt[z][x][y] + 1
                    q.append((nx, ny, z))

                if nx == (n - 1) and ny == (m - 1):
                    print(road_cnt[z][nx][ny])
                    return

                print(road_cnt)
    print(-1)


road_cnt[0][0][0] = 1

bfs(0,0,0)

