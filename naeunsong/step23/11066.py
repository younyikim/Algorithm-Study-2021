import sys

n = int(input())

while n > 0:
    n -= 1
    K = int(input())
    file_list = list(map(int, sys.stdin.readline().split()))
    dp = [[0 for _ in range(K)] for _ in range(K)]
    sum = [0] * (K + 1)
    sum[0] = 0
    sum[1] = file_list[0]
    for i in range(1, K + 1):
        sum[i] = sum[i - 1] + file_list[i - 1]

    for x in range(1, K + 1):
        for i in range(K - x):
            j = i + x
            dp[i][j] = 999999999999
            for k in range(i, j):

    print(dp[0][K - 1])
