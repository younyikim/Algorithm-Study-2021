# 냅색문제
import sys
input = sys.stdin.readline
N, C = map(int, input().split()) # 물건 수, 최대 무게
stuff = list(map(int, input().split()))

left = stuff[:N // 2]
right = stuff[N // 2:]

left_weight = []
right_weight = []

def bf(arr, weight, l, w):
    if l >= len(arr):
        weight.append(w)
        return
    
    bf(arr, weight, l + 1, w)
    bf(arr, weight, l + 1, w + arr[l])


def binary_search(start, end, key, arr):
    while start < end:
        mid = (start + end) // 2
        if arr[mid] <= key:
            start = mid + 1
        else:
            end = mid
    return end
        
bf(left, left_weight, 0, 0)
bf(right, right_weight, 0, 0)

right_weight.sort()

cnt = 0
for i in left_weight:
    if C - i < 0:
        continue
    else:
        cnt += binary_search(0, len(right_weight), C - i, right_weight)

print(cnt)