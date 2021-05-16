import sys

n, s = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))

left = 0
right = 0
tmp = 0
minimum = sys.maxsize


while True:
    if tmp >= s:
        minimum = min(minimum, right - left)
        tmp = tmp - arr[left]
        left = left + 1
    elif right == n:
        break
    else:
        tmp = tmp + arr[right]
        right = right + 1

if minimum == sys.maxsize:
    print(0)
else:
    print(minimum)
