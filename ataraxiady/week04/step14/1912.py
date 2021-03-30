import sys

n = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))

dp=[0 for i in range(n)]

for i in range(n):
    if dp[i] < dp[i-1]:
        dp[i] = dp[i-1]
    dp[i] = dp[i] + arr[i]

print(max(dp))