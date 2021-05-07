# 단지번호 붙이기
N = int(input())
graph = [list(map(int, input())) for _ in range(N)]

mv_row = [-1, 0, 1, 0]
mv_col = [0, 1, 0, -1]

group = list()
cnt = 0
def dfs(r, c):
    global cnt
    graph[r][c] = 0 # 방문 체크
    cnt += 1
    for i in range(4):
        row = r + mv_row[i]
        col = c + mv_col[i]

        if row >= 0 and col >= 0 and row < N and col < N:
            if graph[row][col] == 1:
                dfs(row, col)

for i in range(N):
    for j in range(N):
        if graph[i][j] == 1:
            cnt = 0
            dfs(i,j)
            group.append(cnt)

print(len(group))
group.sort()
for c in group:
    print(c)






