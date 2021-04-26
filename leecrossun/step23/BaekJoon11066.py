# 파일 합치기 python 시간초과 pypy3 성공
import sys
input = sys.stdin.readline
t = int(input())
for _ in range(t):
    K = int(input()) # 파일의 갯수
    file_list = list(map(int,sys.stdin.readline().split())) # 파일 list
    dp = [[0 for _ in range(K)] for _ in range(K)] # memoization

    sum = [0]*(K+1)
    sum[0] = 0
    sum[1] = file_list[0]

    for i in range(1,K+1):
        sum[i] = sum[i-1]+file_list[i-1]
 
    for x in range(1,K+1):
        for i in range(K-x):
            j = i + x
            dp[i][j] = 999999999999
            for k in range(i,j):
                    dp[i][j] = min(dp[i][j], dp[i][k] + dp[k+1][j] + sum[j+1]-sum[i])
 
 
    print(dp[0][K-1])