import sys

n = int(sys.stdin.readline())
# w과 dp 모두 index 1부터 진짜 값을 짚어넣는다
w = [0]
for _ in range(n):
    w.append(int(sys.stdin.readline()))

dp = [0]
# 해당 순서의 포도주를 마시는 경우, 그 전 포도주를 먹는 경우와 안먹는 경우로 나뉘어지고
# 해당 순서를 마시지 않는 경우로 나눌 수 있다.
# 우선 첫번째와 두번째는 연속 세개가 되지않으므로 무조건 마신다.
dp.append(w[1])
if n > 1:
    dp.append(w[1] + w[2])
# 세번 째부터는
# 1. 그 전 순서 포도주 먹는 경우 + 해당 순서 마시기
# 2. 그 전 순서 포도주 안먹는 경우 + 해당 순서 마시기
# 3. 해당 순서 마시기 않기
# 이 세가지 중에 max 값을 찾아 계산해준다.
for i in range(3, n + 1):
    dp.append(max(dp[i - 3] + w[i - 1] + w[i], dp[i - 2] + w[i], dp[i - 1]))
print(dp[n])