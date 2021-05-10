from collections import deque

dx = [0,0,-1,1]
dy = [1,-1,0,0]

M, N = map(int, input().split())

li = []
for _ in range(N):
   li.append(list(map(int, input().split())))

# ch 배열
ch = [[0 for _ in range(M)] for _ in range(N)]


q = deque()

for i in range(N):
    for j in range(M):
        if li[i][j] == 1:
            q.append([i,j,0])
            ch[i][j] = 1



cnt = 0
while q:
    x, y, n = q.popleft()

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx >= 0 and nx < N and ny >= 0 and ny < M and li[nx][ny] == 0:
            if ch[nx][ny] == 0:
                li[nx][ny] = 1
                ch[nx][ny] = 1
                q.append([nx,ny,n+1])

flg = 0
for i in range(N):
    for j in range(M):
        if li[i][j] == 0:
            flg = 1
            break
    if flg == 1:
        break


if flg == 1:
    print(-1)
else:
    print(n)

