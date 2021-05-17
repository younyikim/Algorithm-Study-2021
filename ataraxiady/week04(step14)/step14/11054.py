import sys

n = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))

dp1 = [0 for i in range(n)]
dp2 = [0 for i in range(n)]
total = [0 for i in range(n)]

# 순방향
for i in range(n):
    for j in range(i):
        # index 0부터 i-1까지 arr와 dp값을 비교한다
        # arr[i]가 arr[j]보다 큰데 dp[i]는 작을 경우 dp[i] 값을 dp[j]로 바꿔준다.
        # (값은 큰데 카운트 값은 작은 경우)
        if arr[i] > arr[j] and dp1[i] < dp1[j]:
            dp1[i] = dp1[j]
    # 조건없이 +1을 한다.
    dp1[i] = dp1[i] + 1

# 역방향
for i in range(n-1,-1,-1):
    for j in range(n-1,i,-1):
        if arr[i] > arr[j] and dp2[i] < dp2[j]:
            dp2[i] = dp2[j]
    dp2[i] = dp2[i] + 1

for i in range(n):
    total[i] = dp1[i] + dp2[i] - 1

print(max(total))
