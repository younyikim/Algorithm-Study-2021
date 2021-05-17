import sys

n = int(sys.stdin.readline())
arr = []
check_arr = [False,False] + [True] * (n-1)

# 소수 구하기 (에라토스테네스의 체를 이용하여 )
for i in range(2, n+1):
    if check_arr[i]:
        arr.append(i)
    for j in range(i * i, n + 1, i):
        check_arr[j] = False

sum = 0
left = 0
right = 0
count = 0

while True:
    if sum >= n:
        if sum == n:
            count = count + 1
        sum = sum - arr[left]
        left = left + 1
    elif right == len(arr):
        break
    else:
        sum = sum + arr[right]
        right = right + 1

print(count)