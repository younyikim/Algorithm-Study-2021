# 내리막길
import sys
input = sys.stdin.readline
sys.setrecursionlimit(10000)

def dfs (x, y):
    if dp[x][y] != -1: # memo return
        return dp[x][y]

    if x < 0 or x >= m or y < 0 or y >= n: # 범위 이탈
        return 0

    # dfs 수행
    if x == 0 and y == 0:
        return 1

    dp[x][y] = 0
    for i in range(4):
        X = x + a[i]
        Y = y + b[i]

        if X < 0 or X >= m or Y < 0 or Y >= n: # 범위 이탈
            continue
        if arr[X][Y] > arr[x][y]:
            dp[x][y] += dfs(X, Y)
    
    return dp[x][y]

# main
m, n = map(int, input().split())
arr = list()
for _ in range(m):
    arr.append(list(map(int, input().split())))

dp = [[-1 for _ in range(501)] for _ in range(501)]
a = [1, 0, -1, 0]
b = [0, 1, 0, -1]

print(dfs(m-1, n-1))
