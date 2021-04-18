# K번째 수
n = int(input())
k = int(input())

low = 1
high = k

while low <= high:
    mid = (low + high) // 2
    cnt = 0
    for i in range(1, n+1):
        cnt += min(mid // i, n)
    
    if cnt < k:
        low = mid + 1
    else:    
        high = mid - 1

print(low)