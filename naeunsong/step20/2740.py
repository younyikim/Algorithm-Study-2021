
a, b = map(int, input().split())

matrixA = []
matrixB = []
matrixC = []

for i in range(a):
    matrixA.append(list(map(int, input().split())))

x, y = map(int, input().split())

for i in range(x):
    matrixB.append(list(map(int, input().split())))

matrixC = [[0 for _ in range(y)] for _ in range(a)]

for i in range(a):
    for j in range(y):
        for k in range(b):
            matrixC[i][j] += matrixA[i][k] * matrixB[k][j]


for i in range(a):
    for j in range(y):
        print(matrixC[i][j], end=' ')
    print()