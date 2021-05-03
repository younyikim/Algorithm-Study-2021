import sys
sys.setrecursionlimit(10000)

def dfs(x, y):
    global cabbage, m, n
    dx, dy = [-1, 0, 1, 0], [0, -1, 0, 1]
    cabbage[x][y] = -1
    for i in range(4):
        XX, YY = x + dx[i], y + dy[i]
        if XX < 0 or XX == m or YY < 0 or YY == n:
            continue
        if cabbage[XX][YY] == 1:
            cabbage[XX][YY] = -1
            dfs(XX, YY)

t = int(sys.stdin.readline())
for _ in range(t):
    m, n, k = map(int, sys.stdin.readline().split())
    cabbage = [[0]*n for _ in range(m)]
    count = 0
    for _ in range(k):
        x, y = map(int, input().split())
        cabbage[x][y] = 1
    for i in range(m):
        for j in range(n):
            if cabbage[i][j] > 0:
                dfs(i, j)
                count += 1
    print(count)