# 행렬 곱셈
n1, m1 = map(int, input().split())
matrix1 = list()
for _ in range(n1):
    matrix1.append(list(map(int, input().split())))

n2, m2 = map(int, input().split())
matrix2 = list()
for _ in range(n2):
    matrix2.append(list(map(int, input().split())))

matrix3 = list()
for a in matrix1:
    temp = list()
    for i in range(m2):
        sum = 0
        for j in range(n2):
            sum += matrix2[j][i] * a[j]
        temp.append(sum)
    matrix3.append(temp)

for arr in matrix3:
    for num in arr:
        print(num, end=' ')
    print() 
    
