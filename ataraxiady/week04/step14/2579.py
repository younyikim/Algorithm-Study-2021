import sys
n = int(sys.stdin.readline())
# 점수 받는 배열
s = [0 for i in range(301)]
# 점수의 합 받는 배열
dp = [0 for i in range(301)]

for i in range(n):
    s[i] = int(sys.stdin.readline())

dp[0] = s[0]
dp[1] = s[0] + s[1]
dp[2] = max(s[1] + s[2], s[0] + s[2])
for i in range(3, n):
    dp[i] = max(dp[i - 3] + s[i - 1] + s[i], dp[i - 2] + s[i])
# 마지막 계단부터 계산
print(dp[n - 1])