
n = int(input())

li = []
for _ in range(n):
    li.append(int(input()))

dp = [0 for _ in range(n+1)]
dp_next = [0 for _ in range(n+1)]

dp[n] = li[n-1]
dp[n-1] = dp[n] + li[n-2]
dp_next[n-1] = n

for i in range(n-2, 0, -1):
    if dp_next[i+1] - (i+1) == 1:
        dp[i] = dp[i+2] + li[i-1]
        dp_next[i] = i+2
    else:
        dp[i] = max(dp[i+1], dp[i+2]) + li[i-1]
        if dp[i+1] > dp[i+2]:
            dp_next[i] = i+1
        else:
            dp_next[i] = i+2

if n == 1:
    dp[0] = dp[1]
else:
    dp[0] = max(dp[1], dp[2])

print(dp)
print(dp[0])