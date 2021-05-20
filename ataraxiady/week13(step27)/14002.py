import sys

n = int(sys.stdin.readline())
A = list(map(int, input().split()))

dp = [1 for i in range(n)]
array = [[x] for x in A]

# 가장 긴 부분 수열
for i in range(n):
    for j in range(i):
        if A[i] > A[j]:
            if dp[j] + 1 > dp[i]:
                array[i] = array[j] + [A[i]]
                dp[i] = dp[j] + 1
length = 0
flag = 0
# 긴 수열 찾아내기
for i in range(n):
    if length < dp[i]:
        flag = i
        length = dp[i]
print(length)
print(*array[flag])