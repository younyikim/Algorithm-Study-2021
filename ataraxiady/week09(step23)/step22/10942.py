import sys
N = int(sys.stdin.readline())
num = list(map(int, sys.stdin.readline().split()))
dp = [[0 for _ in range(N)] for _ in range(N)]

# 길이가 1
for i in range(N):
    dp[i][i] = 1

# 길이가 2
for i in range(N-1):
    if num[i] == num[i+1]:
        dp[i][i+1] = 1

# 길이가 3 이상
for l in range(2,N):
    for i in range(N-l):
        if num[i] == num[i+l] and dp[i+1][i+l-1] == 1:
            dp[i][i+l] = 1


M = int(sys.stdin.readline())
for _ in range(M):
    S, E = [int(a) for a in sys.stdin.readline().split()]
    print(dp[S-1][E-1])