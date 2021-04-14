# 행렬제곱
import copy
n, b = map(int, input().split())
m = list()
for _ in range(n):
    m.append(list(map(int, input().split())))

def matrix_product(result, m, n):
    result_matrix = list()
    for a in result:
        temp = list()
        for i in range(n):
            sum = 0
            for j in range(n):
                sum += m[j][i] * a[j]
            temp.append(sum % 1000)
        result_matrix.append(temp)

    return result_matrix 

def calc(a, b, n):
    if b == 1:
        return a
    else:
        matrix = calc(a, b // 2, n)
        if b % 2 == 0:
            return matrix_product(matrix, matrix, n)
        else:
            matrix = matrix_product(matrix, matrix, n)
            return matrix_product(matrix, m, n)

result = calc(m, b, n)

for i in result:
    for j in i:
        if j == 1000:
            j = 0
        print(j,end=' ')
    print()
