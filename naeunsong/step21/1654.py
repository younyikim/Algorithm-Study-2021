
a, b = map(int, input().split())

arr = []
for i in range(a):
    tmp = (int)(input())
    arr.append(tmp)

left = 1
right = max(arr)

while left <= right:
    mid = (left+right)//2

    cnt = 0
    for lan in arr:
        cnt += lan // mid

    if cnt >= b:
        left = mid + 1
        ans = mid
    else:
        right = mid - 1

print(ans)