# 나무 자르기
n, m = map(int, input().split())
height = list(map(int, input().split()))
temp = 0

def calc_height(key, start, end):
    global temp
    if start > end:
        return

    stand = (start + end) // 2
    bring = 0
    for i in height:
        t = i - stand
        if t > 0:
            bring += t

    if bring == key:
        temp = stand
        return temp
    elif bring > key:
        temp = stand
        calc_height(key, stand+1, end)
    else:
        calc_height(key, start, stand-1)
    
    
    
height.sort()
calc_height(m, 0, height[n-1])
print(temp)