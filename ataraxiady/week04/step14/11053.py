import sys

n = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))

dp=[0 for i in range(n)]

for i in range(n):
    for j in range(i):
        # index 0부터 i-1까지 arr와 dp값을 비교한다
        # arr[i]가 arr[j]보다 큰데 dp[i]는 작을 경우 dp[i] 값을 dp[j]로 바꿔준다.
        # (값은 큰데 카운트 값은 작은 경우)
        if arr[i] > arr[j] and dp[i] < dp[j]:
            dp[i] = dp[j]
    # 조건없이 +1을 한다.
    dp[i] = dp[i] + 1

print(max(dp))