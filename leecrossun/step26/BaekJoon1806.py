# 부분합
import sys
input = sys.stdin.readline
N, S = map(int, input().split()) # 길이 / 목표값
arr = list(map(int, input().split()))

ans = N
s = e = 0 # 포인터
sum = 0
ans = N+1

while 1:
    if sum >= S: # 조건을 만족했을경우
        ans = min(ans, e-s) # 만약 최소길이면 갱신
        sum -= arr[s] # 맨 앞 원소 제외해봄
        s += 1 # 앞 포인터 이동
    elif e >= N:
        break
    else: # 조건보다 작으면
        sum += arr[e] # 맨 끝 원소 추가해봄
        e += 1 # 끝 포인터 이동

if ans == N+1:
    print(0)
else:
    print(ans)

