import sys
from bisect import bisect_left

n = int(sys.stdin.readline())
A = list(map(int, sys.stdin.readline().split()))
arr = [0]

for a in A:
    if arr[-1] < a:
        arr.append(a)
    else:
        arr[bisect_left(arr,a)] = a

print(len(arr)-1)