from itertools import combinations_with_replacement
import sys

n,m = map(int, sys.stdin.readline().split())
com = combinations_with_replacement(range(1,n+1),m)

for i in com:
    print(' '.join(map(str,i)))