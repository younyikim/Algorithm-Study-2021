import sys

n = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))
arr.sort()

total = []
c = 0
for i in arr:
    c = c + i
    total.append(c)

print(sum(total))