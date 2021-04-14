import sys

n = int(sys.stdin.readline())
# 이차원 배열 [i-1일때 숫자][끝자리숫자]
dp = [[0]*10 for i in range(101)]

# n=1일 떄
for i in range(1,10):
    dp[1][i] = 1

for i in range(2,101):
    for j in range(10):
        # 끝자리가 0이거나 9일떄는 하나씩만 생긴다.
        # 0으로 끝날 경우에는 그 다음에 1만올 수 있고
        # 9로 끝날 경우에는 8만 올 수 있다.
        if j == 0:
            dp[i][j] = dp[i-1][1]
        elif j == 9:
            dp[i][j] = dp[i-1][8]
        # 그 이외의 경우에는 끝자리보다 하나 작거나 하나 큰 수가 올 수 있다.
        else:
            dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1]

print(sum(dp[n])%1000000000)
