import sys

n = int(sys.stdin.readline())

distances = list(map(int,sys.stdin.readline().split()))
prices = list(map(int,sys.stdin.readline().split()))

c = 0
m = prices[0]

for i in range(n-1):
    if prices[i] < m:
        m = prices[i]
    c = c + m * distances[i]

print(c)