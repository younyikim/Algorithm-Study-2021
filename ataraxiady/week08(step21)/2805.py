import sys

N, M = map(int, sys.stdin.readline().split())
H = list(map(int, sys.stdin.readline().split()))
start, end = 1, max(H)

while start <= end:
    mid = (start + end) // 2
    total = 0

    for i in H:
        if i >= mid:
            total += i - mid

    if total >= M:
        start = mid + 1
    else:
        end = mid - 1
print(end)
