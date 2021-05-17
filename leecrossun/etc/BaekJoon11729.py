# 하노이 탑 이동순서
def hanoi(n, a, b, c): # 원반의 수 / 출발지 / 나머지 / 목적지
    if n == 1: # 하나 남았으면
        move.append([a,c]) # a에서 c로
    else: # 아니면
        hanoi(n-1, a, c, b) # a에서 b로
        move.append([a,c])
        hanoi(n-1, b, a, c)

N = int(input())
move = []
hanoi(N, 1, 2, 3)

print(len(move))

for i in move:
    print(i[0], i[1])
    
