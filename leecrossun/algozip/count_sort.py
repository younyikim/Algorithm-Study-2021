# 계수 정렬
array = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]
count = [0] * (max(array)+1)

l = len(array)
for i in range(l):
    count[array[i]] += 1

# 등장한 횟수만큼 출력
for i in range(l):
    for j in range(count[i]):
        print(i, end=' ')