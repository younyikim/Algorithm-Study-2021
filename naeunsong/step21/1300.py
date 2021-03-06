# 1 2 3
# 2 4 6
# 3 6 9
N = int(input())
K = int(input())

start, end = 1, K

while start <= end:
    mid = (start + end) // 2
    tmp = 0

    for i in range(1, N+1) :
        tmp += min(mid // i, N)
    if tmp >= K:
        ans = mid
        end = mid - 1
    else:
        start = mid + 1

print(ans)
