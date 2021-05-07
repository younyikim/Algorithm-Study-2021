n = int(input())
values = list()

for i in range(n):
    w,h = map(int,input().split())
    values.append([w,h])

for x,y in values:
    rank = 1
    for p, q in values:
        if values.index([x,y]) == values.index([p,q]):
            continue
        if p > x and q > y:
            rank = rank+1
    print(rank, end=' ')