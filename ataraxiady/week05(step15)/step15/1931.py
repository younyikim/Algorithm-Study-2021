import sys

n = int(sys.stdin.readline())
arr = []
for _ in range(n):
    arr.append(list(map(int, sys.stdin.readline().split())))

arr.sort(key=lambda x:x[0])
arr.sort(key=lambda x:x[1])

c = 0
e = 0

for i,j in arr:
    if i >= e:
        e = j
        c = c + 1


print(c)