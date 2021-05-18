# 가장 긴 증가하는 부분 수열 4
a = int(input())
arr = list(map(int, input().split()))
dp = list()
dp.append([0,0])
for item in arr:
    dp.append([1, item])

# print(dp)

for i in range(1, a): # arp
    # print(i, 1, i+1)
    for j in range(1, i+1): # dp
        # print(arr[i],dp[j][dp[j][0]])
        if arr[i] > dp[j][dp[j][0]]:
            dp[j].append(arr[i])
            dp[j][0] += 1
    # print("----------------")

# print(dp)
max = 0
max_index = 0
for i in range(a+1):
    # print(dp[i][0])
    if dp[i][0] > max:
        # print("debug")
        max = dp[i][0]
        max_index = i

print(dp[max_index][0])
for i in range(1,dp[max_index][0]+1):
    print(dp[max_index][i], end=' ')

