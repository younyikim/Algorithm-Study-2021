import sys

n = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))
x = int(sys.stdin.readline())

answer = 0
left = 0
right = n-1

arr.sort()
while left < right:
    tmp = arr[left] + arr[right]
    if tmp < x:
        left = left + 1
    if tmp == x:
        answer = answer + 1
        left = left + 1
    if tmp > x:
        right = right - 1

print(answer)