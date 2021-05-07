from collections import deque

dx = [0,0,-1,1]
dy = [1,-1,0,0]

M, N = map(int, input().split())

li = []
for _ in range(N):
   li.append(list(map(int, input().split())))

# ch 배열
ch = [[0 for _ in range(M)] for _ in range(N)]
print(ch)


q = deque()

for i in range(N):
    for j in range(M):
        if li[i][j] == 1:
            q.append([i,j])
            ch[i][j] = 1



cnt = 0
while q:
    x, y = q.pop()

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        std_num = 1
        if nx >= 0 and nx < N and ny >= 0 and ny < M and li[nx][ny] == 0:
            if ch[nx][ny] == 0:
                li[nx][ny] = 1
                ch[nx][ny] = 1
                q.append([nx,ny])
                cnt += 1
                std_num -= 1



print(cnt)


