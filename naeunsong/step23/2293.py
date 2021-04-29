a, b = map(int, input().split())

arr = []
for i in range(a):
    arr.append(int(input()))

cnt = 0

def recur(total, sum, idx):
    global cnt
    if total == sum:
        cnt+=1
        return
    elif total < sum:
        return


    if idx > a-1:
        return

    recur(total, sum+arr[idx], idx+1)
    recur(total, sum - arr[idx], idx + 1)

recur(b, 0, 0)
print(cnt)