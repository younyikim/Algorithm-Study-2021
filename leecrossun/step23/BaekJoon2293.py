# 동전 1
import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)
n, k = map(int, input().split()) # n : 동전의 종류  k : 구하고자 하는 동전의 합
coins = list()
for _ in range(n):
    coins.append(int(input()))

dp = [0 for _ in range(k+1)]
dp[0] = 1

for coin in coins: # 각 동전 별로 루프
    for i in range(coin, k+1): # 동전 ~ k 까지 루프
        if i >= coin:  # 합이 i 가 되는 경우의 수  = sum(합이 i - coin 이 되는 경우의 수)
            dp[i] += dp[i - coin] 

print(dp[k])
