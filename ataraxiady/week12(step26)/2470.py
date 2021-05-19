import sys

n = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))
arr.sort()

left = 0
right = n-1
al = left
ar = right
min = arr[left] + arr[right]

while left < right:
    tmp = arr[left] + arr[right]
    if abs(tmp) < abs(min):
        min = tmp
        al = left
        ar = right
        if min == 0:
            break
    if tmp < 0:
        left = left + 1
    else:
        right = right - 1

print(arr[al], arr[ar])