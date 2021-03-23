import sys
n = int(sys.stdin.readline())
t = []
for i in range(n):
    t.append(list(map(int,sys.stdin.readline().split())))
k = 2

# 맨 밑에서 부터 최대값을 찾아 올라가며 계산한다.
# 맨 왼쪽, 오르쪽 숫자들은 자기 바로 위 숫자를 더하면 된다.
# 나머지는 왼쪽 위 숫자와 오른쪽 위 숫자를 비교하여 큰 값을 더한다.
for i in range(1, n):
    for j in range(k):
        if j == 0:
            t[i][j] = t[i][j] + t[i - 1][j]
        elif i == j:
            t[i][j] = t[i][j] + t[i - 1][j - 1]
        else:
            t[i][j] = max(t[i - 1][j - 1], t[i - 1][j]) + t[i][j]
    k += 1
print(max(t[n - 1]))