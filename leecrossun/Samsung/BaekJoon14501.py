# 퇴사
N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
answer = [0] * N

for i in range(N-1, -1, -1):
    start = arr[i][0]
    money = arr[i][1]

    if start > N - i:
        if i != N - 1:
            answer[i] = answer[i+1]
        continue
        
    if i == N-1:
        answer[i] = money
    elif i + start == N:
        answer[i] = max(money, answer[i+1])
    else:
        answer[i] = max(money + answer[i + start], answer[i+1])

print(answer[i])



