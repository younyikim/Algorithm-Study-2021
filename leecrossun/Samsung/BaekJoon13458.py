# 시험감독
import math
N = int(input()) # 시험장의 수
A = list(map(int, input().split())) # i번 시험장의 응시자의 수
B, C = map(int, input().split()) # 총감독관 감시 / 부감독관 감시
answer = N # 각 시험장별로 총감독관 1명씩

for r in A:
    r -= B
    if r > 0: answer += math.ceil(r/C)

print(answer)