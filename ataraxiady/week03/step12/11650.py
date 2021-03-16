import sys

n = int(sys.stdin.readline())
coordinates = []

for _ in range(n):
    x, y = map(int, sys.stdin.readline().split())
    coordinates.append([x, y])

coordinates.sort()
for xy in coordinates:
    print(xy[0],xy[1])