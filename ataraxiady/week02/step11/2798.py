n,m = map(int,input().split())
cards = list(map(int,input().split()))
total = 0
max = 0
for i in cards:
    for j in cards:
        # 같은 카드를 비교할 일 없도록 한다.
        if j == i:
            continue
        for k in cards:
            # 같은 카드를 비교할 일 없도록 한다.
            if k == j or k == i:
                continue
            if i + j + k <= m:
                total = i + j + k
                if total > max:
                    max = total
print(max)
