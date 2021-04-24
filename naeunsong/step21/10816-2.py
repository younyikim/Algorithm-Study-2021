n = (int)(input())

arrayA = []
arrayA = list(map(int, input().split()))

m = (int)(input())

arrayB = []
arrayB = list(map(int, input().split()))

dict = dict()
for i in arrayA:
    if i in dict:
        dict[i] += 1
    else:
        dict[i] = 1

for i in arrayB:
    if i in dict:
        print(dict[i], end=" ")
    else:
        print(0, end=" ")
