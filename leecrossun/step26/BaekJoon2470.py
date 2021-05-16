# 두 용액
import sys
input = sys.stdin.readline
N = int(input())
arr = list(map(int, input().split())) # 특성값
arr.sort()

i, j = 0, N-1
answer = [arr[i],arr[j]] # 답
value = abs(arr[i] + arr[j]) # 0에 가까운 특성값
while i < j:
    sum = arr[i] + arr[j]
    abs_sum = abs(sum)
    if abs_sum < value: # 0에 더 가까우면 답 갱신
        answer[0] = arr[i]
        answer[1] = arr[j]
        value = abs_sum

    if value == 0: # value 가 0이면 바로 답
            break    

    if sum >= 0: # 특성값 합이 양수면
        j -= 1 # j 이동 -> 합을 줄인다
    else: # 음수면
        i += 1 # i 이동 -> 합을 늘린다   
    
print(answer[0], answer[1])
    

