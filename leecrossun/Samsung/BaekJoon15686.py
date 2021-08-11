# 치킨 배달
from itertools import combinations

n, m = map(int, input().split()) # 크기, 치킨집 최대 개수

c_list = list() # 치킨 좌표 리스트
h_list = list() # 집 좌표 리스트

# 도시 정보 (0 빈칸 1 집 2 치킨집)
for i in range(n):
    temp = list(map(int, input().split()))
    for j in range(n):
        if temp[j] == 1:
            h_list.append([i,j])
        if temp[j] == 2:
            c_list.append([i,j])

# m개의 치킨집 조합
c_comb = list(combinations(c_list, m))

dist_list = list()
for chick in c_comb:
    dist = 0
    for home in h_list:
        m = (n-1)*(n-1)
        r1, c1 = home[0], home[1]
        for ch in chick:
            r2, c2 = ch[0], ch[1]
            d = abs(r1-r2) + abs(c1-c2)
            if m > d:
                m = d
        dist += m
    dist_list.append(dist)
print(min(dist_list))