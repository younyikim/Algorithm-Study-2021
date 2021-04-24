
# 1. mid 값 = 집마다 최소 거리
# 2. 거리를 기준으로 카운트하고 공유기 개수가 m보다 많으면 거리를 늘려주고, 공유기 개수가 m보다 적으면 거리를 줄여준다.

n, c = map(int, input().split())

loc = []
for _ in range(n):
    loc.append(int(input()))

loc.sort()

# 거리의 최솟값, 최대값
start = 1
end = loc[-1] - loc[0]

result = 0

while (start <= end):
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