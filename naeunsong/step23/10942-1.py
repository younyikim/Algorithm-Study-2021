import sys

N = int(sys.stdin.readline())
num_list = list(map(int, sys.stdin.readline().split()))
dp = [[0 for _ in range(N)] for _ in range(N)]

for i in range(N):
    dp[i][i] = 1
    if i < N - 1 and num_list[i] == num_list[i + 1]:
        dp[i][i + 1] = 1

for i in range(1, N):
    for j in range(1, i + 1):
        if num_list[i] == num_list[i - j] and dp[i - j + 1][i - 1] == 1:
            dp[i - j][i] = 1

M = int(sys.stdin.readline())
for _ in range(M):
    S, E = map(int, sys.stdin.readline().split())
    print(dp[S - 1][E - 1])
