#  유기농 배추
import sys
sys.setrecursionlimit(10000)
input = sys.stdin.readline

def dfs(r, c):
    graph[r][c] = 0 # 방문 체크
    for i in range(4):
        row = r + mv_row[i]
        col = c + mv_col[i]

        if row >= 0 and col >= 0 and row < N and col < M:
            if graph[row][col] == 1:
                dfs(row, col)

T = int(input())
for _ in range(T):
    M, N, K = map(int, input().split())
    graph = [[0] * M for _ in range(N)]
    for _ in range(K):
        x, y = map(int, input().split())
        graph[y][x] = 1


    mv_row = [-1, 0, 1, 0]
    mv_col = [0, 1, 0, -1]

    cnt = 0
    for i in range(N):
        for j in range(M):
            if graph[i][j] == 1:
                cnt += 1
                dfs(i,j)

    print(cnt)