
from collections import deque


dx = [1,-1,0,0]
dy = [0,0,1,-1]
q = deque()


a, b = map(int, input().split())
visited = [[[[False]*b for _ in range(a)] for _ in range(b)] for _ in range(a)]

arr = []
for _ in range(a):
    tmp = list(map(str, input()))
    arr.append(tmp)

def init():
    rx, ry, bx, by = [0] * 4
    for i in range(a):
        for j in range(b):
            if arr[i][j] == 'R':
                rx, ry = i, j
            elif arr[i][j] == 'B':
                bx, by = i, j
    q.append((rx,ry,bx,by,1))
    visited[rx][ry][bx][by] = True

def move(x,y,dx,dy):
    count = 0  # 이동한 칸 수
    # 다음 이동이 벽이거나 구멍이 아닐 때까지
    while arr[x + dx][y + dy] != '#' and arr[x + dx][y + dy] != 'O':
        x += dx
        y += dy
        count += 1
    return x, y, count


def bfs():
    init()
    while q:
        rx, ry, bx, by, depth = q.popleft() # FIFO
        if depth > 10:
            break
        for i in range(len(dx)):
            n_rx, n_ry, r_count = move(rx,ry,dx[i],dy[i])
            n_bx, n_by, b_count = move(bx,by,dx[i],dy[i])

            if arr[n_bx][n_by] == 'O':
                continue
            if arr[n_rx][n_ry] == 'O':
                print(depth)
                return

            if n_rx == n_bx and n_ry == n_by:  # 빨간 구슬과 파란 구슬이 동시에 같은 칸에 있을 수 없다.
                if r_count > b_count:  # 이동 거리가 많은 구슬을 한칸 뒤로
                    n_rx -= dx[i]
                    n_ry -= dy[i]
                else:
                    n_bx -= dx[i]
                    n_by -= dy[i]

            if not visited[n_rx][n_ry][n_bx][n_by]:
                visited[n_rx][n_ry][n_bx][n_by] = True
                q.append((n_rx,n_ry,n_bx,n_by,depth+1))
    print(-1)

bfs()