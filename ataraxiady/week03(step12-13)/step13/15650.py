from itertools import combinations
import sys

n,m = map(int, sys.stdin.readline().split())
com = combinations(range(1,n+1),m)

for i in com:
    print(' '.join(map(str,i)))
