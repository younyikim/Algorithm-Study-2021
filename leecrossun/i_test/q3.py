from collections import deque
def reachTheEnd(grid, maxTime):
    r, c = 0, 0
    q.append([r,c])
    grid[r][c] = '#'
    while q:
        y, x = q.popleft()
        print(y,x,M,N)
        if x == M-1 and y == N-1:
            return "Yes"

        for i in range(4):
            nX = x + dir_c[i]
            nY = y + dir_r[i]

            if 0 <= nX < M and 0 <= nY < N:
                if grid[nY][nX] == '.' and not visited[nY][nX]:
                    visited[nY][nX] = True
                    q.append([nY, nX])
                    cnt[nY][nX] += cnt[y][x] + 1

    if (0 < cnt[N-1][M-1] <= maxTime): return "Yes"
    else: return "No"

q = deque()
dir_r = [-1, 0, 1, 0]
dir_c = [0, 1, 0, -1]

grid_count = int(input().strip())
grid = []
for _ in range(grid_count):
    grid_item = list(input())
    grid.append(grid_item)

N, M = grid_count, len(grid[0])


visited = [[False]*M for _ in range(N)]
visited[0][0] = True
cnt = [[0]*M for _ in range(N)]
cnt[0][0] = 0


maxTime = int(input().strip())
print(reachTheEnd(grid, maxTime))