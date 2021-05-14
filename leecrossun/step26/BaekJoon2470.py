# 두 용액
import sys
input = sys.stdin.readline
N = int(input())
arr = list(map(int, input().split()))
arr.sort()

i, j = 0, N-1
answer = [arr[i],arr[j]]
while i + 1 < j:
    sum1 = abs(arr[i+1] + arr[j])
    sum2 = abs(arr[i] + arr[j-1])
    
    x = y = 0
    if sum1 > sum2:
        sum = sum2
        x, y = i, j-1
    else:
        sum = sum1
        x, y = i+1, j

    if abs(answer[0] + answer[1]) > sum:
        answer[0] = arr[x]
        answer[1] = arr[y]
    
    i += 1
    j -= 1

print(answer[0], answer[1])
    

