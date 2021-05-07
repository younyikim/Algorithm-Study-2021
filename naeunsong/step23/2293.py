a, b = map(int, input().split())

arr = []
for i in range(a):
    arr.append(int(input()))

cnt = 0

def recur(total, sum, mid_idx):
    global cnt
    if total == sum:
        cnt+=1
        return
    elif total < sum:
        return

    for i in range(mid_idx,a):
        recur(total, sum + arr[i], i)

recur(b, 0, 0)
print(cnt)

# 1 1 1 1 1 1 1 1 1 1 -> o
# 1 1 1 1 1 1 1 1 2 -> o
# 1 1 1 1 1 1 1 1 3 -> x
# 1 1 1 1 1 1 1 1 5 -> x
# 1 1 1 1 1 1 1 2 2 -> x
# 1 1 1 1 1 1 1 2 3 -> x
# 1 1 1 1 1 1 1 1 5 -> x
# 1 1 1 1 1 1 2 2 -> o
# 1 1 1 1 1 1 2 3 -> x
# 1 1 1 1 1 1 1 5 -> x
# 1 1 1 1 1 2 2 2 -> x

