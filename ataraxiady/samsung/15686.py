import sys
from itertools import combinations

n, m = map(int, sys.stdin.readline().split())
house = []
chicken = []

for r in range(n):
    temp = list(map(int, sys.stdin.readline().split()))
    for c in range(n):
        if temp[c] == 1:
            house.append([r, c])
        elif temp[c] == 2:
            chicken.append([r, c])

# 조합을 통해 치킨집을 랜덤으로 m개 고른 후 거리 계산을 통하여 최소 거리가 나오는 것을 선택한다.
chicken_list = list(combinations(chicken, m))
answer = []
for i in chicken_list:
    total = 0
    for h_r, h_c in house:
        minimum = 2 * (n - 1)
        for c_r, c_c in i:
            dis = abs(h_r - c_r) + abs(h_c - c_c)
            if dis == 1:
                minimum = dis
                break
            if dis < minimum:
                minimum = dis
        total += minimum
    answer.append(total)

print(min(answer))
