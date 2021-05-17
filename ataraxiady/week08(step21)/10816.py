from collections import Counter
import sys

n = int(sys.stdin.readline())
card = list(map(int,sys.stdin.readline().split()))
card = Counter(card)
m = int(sys.stdin.readline())
check = list(map(int,sys.stdin.readline().split()))

for num in check:
    print(card[num], end=" ")