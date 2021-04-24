# 공유기 설치
n, c = map(int, input().split())
home = list()
for _ in range(n):
    home.append(int(input()))

home.sort()

start = 1
end = home[-1] - home[0]

result = 0

while start <= end:
    mid = (start + end) // 2
    index = 0
    cnt = 1

    for i in range(1, len(home)):
        if home[index] + mid <= home[i]:
            cnt += 1
            index = i
    
    if cnt < c:
        end = mid - 1
    
    elif cnt >= c:
        result = mid
        start = mid + 1

print(result)