import sys

n = sys.stdin.readline()
A = list(map(int, sys.stdin.readline().split()))
B, C = map(int, sys.stdin.readline().split())

num = 0
# 시간초과
# for i in A:
#     i = i - B
#     num += 1
#     if i > 0:
#         j = 1
#         while i - (C * j) > 0:
#             j += 1
#         num += j

for i in A:
    i = i - B
    num += 1
    if i > 0:
        num = num + (i // C)
        if i % C != 0:
            num += 1


print(num)