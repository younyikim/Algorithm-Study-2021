# 랜선 자르기
k, n = map(int, input().split())
arr = list()
for _ in range(k):
    arr.append(int(input()))
temp = 0

def binary_search(key, start, end):
    global temp
    if start > end:
        return
    
    lan = (start + end) // 2
    cnt = 0
    for i in arr:
        cnt += i // lan

    print("cnt : ", cnt, "lan : ",lan)
    
    if cnt == key:
        temp = lan
        return
    elif cnt > key:
        if lan > temp:
            temp = lan
        binary_search(key, lan+1, end)
    else:
        binary_search(key, start, lan-1)


arr.sort()
binary_search(n, 1, arr[k-1])
print(temp)