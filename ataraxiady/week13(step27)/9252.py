import sys

a = [0] + list(sys.stdin.readline().strip())
b = [0] + list(sys.stdin.readline().strip())
len_a = len(a)
len_b = len(b)
dp = [[""] * len_b for i in range(len_a)]

# i는 첫번째 문자열 인덱스 j는 두번째문자열 인덱스
for i in range(1, len_a):
    for j in range(1, len_b):
        # 같은 문자일 경우
        if a[i] == b[j]:
            dp[i][j] = dp[i - 1][j - 1] + a[i]
        else:
            # 다른 문자일 경우 더 긴 문자열을 대입한다.
            if len(dp[i - 1][j]) > len(dp[i][j - 1]):
                dp[i][j] = dp[i - 1][j]
            else:
                dp[i][j] = dp[i][j - 1]

print(len(dp[len_a - 1][len_b - 1]))
print(dp[len_a - 1][len_b - 1])