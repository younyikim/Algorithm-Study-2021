import sys

n, k = map(int, sys.stdin.readline().split())
value = []
for _ in range(n):
    value.append(int(sys.stdin.readline()))


dp = [0 for i in range(k + 1)]
dp[0] = 1

for i in value:
    for j in range(1, k + 1):
        if j - i >= 0:
            dp[j] += dp[j - i]
print(dp[k])