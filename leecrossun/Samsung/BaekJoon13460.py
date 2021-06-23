# 구슬 탈출 2
import sys
from collections import deque
input = sys.stdin.readline

N, M = map(int, input().split()) # 세로 / 가로
board = list() # 보드
for _ in range(N):
    board.append(input())

R, B = [0,0], [0,0] # 빨간 구슬 / 파란 구슬
for i in range(N):
    for j in range(M):
        if board[i][j] == 'R':
            R = [i, j]
        if board[i][j] == 'B':
            B = [i, j]

r_visited = [[False] * M for _ in range(N)] # 방문
b_visited = [[False] * M for _ in range(N)] # 방문
c = [1, 0, -1, 0] # 왼오
r = [0, 1, 0, -1] # 위아래

def move(x, y, r, c):
    length = 0

    # 빨간 구슬 이동
    while board[x+r][y+c] != '#':
        if board[x+r][y+c] == 'O':
            return False, False, False
        x += r
        y += c
        length += 1
    return x, y, length

def bfs():
    q = deque()
    q.append([R[0], R[1], B[0], B[1], 0])
    r_visited[R[0]][R[1]] = True
    b_visited[B[0]][B[1]] = True

    while q:
        srx, sry, sbx, sby, cnt = q.popleft() # 이동 전 지점
        
        if cnt >= 10:
            print(-1)
            return

        for d in range(4):
            # 이동
            rx, ry, rl = move(srx, sry, r[d], c[d]) # 빨간 구슬 이동
            bx, by, bl = move(sbx, sby, r[d], c[d]) # 파란 구슬 이동

            if not bx: # 파란구슬만 빠졌으면 손절
                continue
            elif not rx: # 빨간구슬만 빠졌으면 성공
                cnt += 1
                print(cnt)
                return

            # 겹쳤을 경우
            if rx == bx and ry == by:
                if rl > bl:
                    rx -= r[d]
                    ry -= c[d]
                else:
                    bx -= r[d]
                    by -= c[d]

            q.append([rx, ry, bx, by, cnt+1])

    print(-1)
    return

bfs()