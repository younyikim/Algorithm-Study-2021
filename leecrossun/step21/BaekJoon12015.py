# 가장 긴 증가하는 부분 수열2
n = int(input())
a = list(map(int, input().split()))

l = [0]

for i in a:
    if l[-1] < i:
        l.append(i)
    else:
        left = 0
        right = len(l)

        while left < right:
            mid = (right + left) // 2
            if l[mid] < i:
                left = mid + 1
            else:
                right = mid
        
        l[right] = i

print(len(l)-1)