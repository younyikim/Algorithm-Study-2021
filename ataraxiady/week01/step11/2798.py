n,m = map(int,input().split())
cards = list(map(int,input().split()))
total = 0
max = 0
for i in cards:
    for j in cards:
        if j == i:
            continue
        for k in cards:
            if k == j or k == i:
                continue
            if i + j + k <= m:
                total = i + j + k
                if total > max:
                    max = total
print(max)
