
def binary(A, num, left, right, ans):
    if left > right:
        return 0

    mid = (left+right)//2

    cnt = 0
    for lan in A:
        cnt += lan // mid

    if cnt >= num:
        return binary(A, num, mid+1, right, mid)
    else:
        return binary(A, num, left, mid-1, ans)

a, b = map(int, input().split())

arr = []
for i in range(a):
    tmp = (int)(input())
    arr.append(tmp)

left = 1
right = min(arr)

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