
a, b = map(int, input().split())

matrixA = []
matrixB = []
matrixC = []

for i in range(a):
    matrixA.append(list(map(int, input().split())))


matrixB = [[0 for _ in range(a)] for _ in range(a)]
matrixC = [[0 for _ in range(a)] for _ in range(a)]

matrixB = matrixA[:]
for l in range(b):
    for i in range(a):
        for j in range(a):
            for k in range(a):
                matrixC[i][j] += matrixB[i][k] * matrixA[k][j]
    matrixB = matrixC[:]
    print(matrixB)


for i in range(a):
    for j in range(a):
        print((matrixC[i][j])%1000, end=' ')
    print()