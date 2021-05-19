# 가장 긴 증가하는 부분 수열 4
from collections import deque
a = int(input())
arr = list(map(int, input().split()))
dp = [1] * a
# print(dp)

for i in range(a): # arp
    # print(i, 1, i+1)
    for j in range(i): # dp
        # print(arr[i],dp[j][dp[j][0]])
        if arr[i] > arr[j] and dp[i] < dp[j]+1:
            dp[i] = dp[j] + 1
    # print("----------------")

index = dp.index(max(dp))
c = dp[index]
d = deque()
for i in range(index-1, -1, -1):
    if c == dp[i] + 1:
        c = dp[i]
        d.appendleft(arr[i])

d.append(arr[index])

print(max(dp))
print(' '.join(map(str,d)))
