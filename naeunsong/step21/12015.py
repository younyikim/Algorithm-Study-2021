
n = int(input())

loc = list(map(int, input().split()))

# 거리의 최솟값, 최대값
start = 0
end = max(loc) - min(loc)

result = 0


for i in range(n):
    mid = (start + end) // 2  # 최소 거리
    router = loc[0]
    count = 1

    for i in range(1, len(loc)):
        if loc[i] >= router + mid:
            count += 1
            router = loc[i]

    if count >= c:
        start = mid + 1
        result = mid
    else:
        end = mid - 1

print(result)