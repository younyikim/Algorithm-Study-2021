# 숫자 카드2
import sys
from collections import Counter
input = sys.stdin.readline
n = int(input()) # 숫자카드의 개수
card = list(map(int, input().split())) # 숫자카드에 적힌 정수
m = int(input()) # 구해야 할 정수의 개수
arr = list(map(int, input().split())) # 구해야하는 정수
temp = 0

result = Counter(card)
for i in arr:
    n = result.get(i)
    if n == None:
        n = 0
    print(n, end=' ')

