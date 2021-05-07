# 앱
import sys
input = sys.stdin.readline
N, M = map(int, input().split())
m_arr = [0] + list(map(int, input().split())) # memory byte
c_arr = [0] + list(map(int, input().split())) # cost

m_sum = sum(m_arr)
c_sum = sum(c_arr)
dp = [[0 for _ in range(c_sum+1)] for _ in range(N+1)]
min_cost = c_sum

for i in range(1, N+1):
    m = m_arr[i]
    c = c_arr[i]

    for j in range(1, c_sum + 1):
        if c > j:
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j] = max(m + dp[i-1][j-c], dp[i-1][j])
        
        if dp[i][j] >= M:
            min_cost = min(min_cost, j)
            
print(min_cost)