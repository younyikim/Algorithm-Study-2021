# 회전하는 큐
import collections
n, m = map(int, input().split())
index_list = list(map(int, input().split()))
num = collections.deque([0]*n)

for i in index_list:
    num[i-1] = i

cnt = 0  
for i in range(m):
    index = num.index(index_list[i])
    length = len(num)

    if index < length - index:
        num.rotate(-1 * index)
        num.popleft()
        cnt += index
    else:
        num.rotate(length - index);
        num.popleft()
        cnt += (length - index)

print(cnt)